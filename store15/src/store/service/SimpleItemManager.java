package store.service;

import java.math.BigDecimal;
import java.util.List;

import net.authorize.Environment;
import net.authorize.api.contract.v1.CreateTransactionRequest;
import net.authorize.api.contract.v1.CreateTransactionResponse;
import net.authorize.api.contract.v1.CreditCardType;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.contract.v1.TransactionRequestType;
import net.authorize.api.contract.v1.TransactionResponse;
import net.authorize.api.contract.v1.TransactionTypeEnum;
import net.authorize.api.controller.CreateTransactionController;
import net.authorize.api.controller.base.ApiOperationBase;

import store.domain.Customer;
import store.domain.Item;
import store.repository.ItemDao;

public class SimpleItemManager implements ItemManager{
  
	private ItemDao itemDao;
	
	//Get the list of items in the cart
	public List<Item> getItems(Object user_session_id) {
		  return itemDao.getItemList(user_session_id);  
	}
	
	//The number of items of a particular user
	public int user_items(Object user_session_id){
		return itemDao.user_item(user_session_id);
	}
	
	//Add a new item in the cart or Update item if exists
	public void add_cartItem(String product_id, Object user_session_id){
		
		//IF THE PRODUCT DOESNT EXIST, WE WILL ADD IT IN THE TABLE CART
		if(getCountOneCartItem(product_id, user_session_id)==0){
		  itemDao.insertItem(getOneItemForCart(product_id, user_session_id));
		}else{//IF THE PRODUCT EXISTS, WE WILL INCREMENT ITS QUANTITY IN THE TABLE CART
			Item item = getOneCartItem(product_id, user_session_id);
			item.quantity++;
			update_cartItem( product_id,  item.quantity, user_session_id);
		}
	}
	public Item getOneItemForCart(String product_id, Object user_session_id){
		return itemDao.getOneItem(product_id, user_session_id);
	}
	public int getCountOneCartItem(String product_id, Object user_session_id){
		return itemDao.getCountCartItem(product_id, user_session_id); 
	}
	public Item getOneCartItem(String product_id, Object user_session_id){
		return itemDao.getCartItem(product_id, user_session_id);
	}
	public void update_cartItem(String product_id, int quantity, Object user_session_id){
		itemDao.updateItem(product_id, quantity, user_session_id);
	}
	
	//Delete an existing item
	public void delete_cartItem(String product_id, Object user_session_id){
		itemDao.deleteItem(product_id, user_session_id);
	}
	
	//Update an existing item
    public void update_cartItem(String product_id, String quantity, Object user_session_id){
		if(quantity.matches("0")){//when the quantity is equal to zero
			itemDao.deleteItem(product_id, user_session_id);
		}
		else{//when the quantity is different from zero
		  int j=0;
		  for(int i=1;i<5000;i++){
			  if(quantity.matches(Integer.toString(i))){
				  j=j+1;
			  }
		  }
		  //if the quantity is a number greater than 4999 or a string, then the user will receive a message
		  if(j==0){
			  String message = "Please enter a valid number!";
			  itemDao.updateItem2(product_id, message, user_session_id);
		  }else{//if the quantity is a number lower than 5000, then do the action
		      itemDao.updateItem(product_id, quantity, user_session_id);
		  
		      //Test if the quantity is in stock
		      if(itemDao.getOneProduct(product_id).getStock()<itemDao.getCartItem(product_id, user_session_id).getQuantity())
		      {
			    String message = "This quantity is not available";
			    itemDao.updateItem2(product_id, message, user_session_id);
		      }else
		      {
			    String message = "";
			    itemDao.updateItem2(product_id, message, user_session_id);
		      }
		   } 	  
         }
    }
	
    //Add the subtotal of a particular user
  	public void add_orders(Object customer_id, Object total, String card_number){
  		itemDao.add_order(customer_id, total, card_number);
  	}
	
    //Check if a user has got an order
  	public int getcountorders(Object customer_id){
  		return itemDao.getcountorder(customer_id);
  	}
	
    //Add a customer
  	public void add_customers(Object customer_id, Customer customer){
  		if (getcountcustomers(customer_id)==0){
  		  this.itemDao.add_customer(customer_id, customer);
  		}else{
  			this.itemDao.update_customer(customer_id, customer);
  		}
  	}
    //Check if a user has his details in the database: customer ID is the email address
  	public int getcountcustomers(Object customer_id){
  		return itemDao.getcountcustomer(customer_id);
  	}
  	
  	
    //add a receipt
  	public void add_receipts(List<Item> listItems, Object customer_id){
  		this.itemDao.add_receipt(listItems, customer_id);
  		
  	}
  	
  	
  	//Charge credit card
  	public void chargecreditcard(){
  	    //Common code to set for all requests
        ApiOperationBase.setEnvironment(Environment.SANDBOX);

        MerchantAuthenticationType merchantAuthenticationType  = new MerchantAuthenticationType() ;
        merchantAuthenticationType.setName("3wUdmG925Dga");//YOUR_API_LOGIN_ID
        merchantAuthenticationType.setTransactionKey("7UN45uF9F9up8YP");//YOUR_TRANSACTION_KEY
        ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);

        // Populate the payment data
        PaymentType paymentType = new PaymentType();
        CreditCardType creditCard = new CreditCardType();
        creditCard.setCardNumber("4242424242424242");
        creditCard.setExpirationDate("0822");
        paymentType.setCreditCard(creditCard);

        // Create the payment transaction request
        TransactionRequestType txnRequest = new TransactionRequestType();
        txnRequest.setTransactionType(TransactionTypeEnum.AUTH_CAPTURE_TRANSACTION.value());
        txnRequest.setPayment(paymentType);
        txnRequest.setAmount(new BigDecimal(500.00));

        // Make the API Request
        CreateTransactionRequest apiRequest = new CreateTransactionRequest();
        apiRequest.setTransactionRequest(txnRequest);
        CreateTransactionController controller = new CreateTransactionController(apiRequest);
        controller.execute();


        CreateTransactionResponse response = controller.getApiResponse();

        if (response!=null) {

            // If API Response is ok, go ahead and check the transaction response
            if (response.getMessages().getResultCode() == MessageTypeEnum.OK) {

                TransactionResponse result = response.getTransactionResponse();
                this.itemDao.add_transaction(result.getResponseCode());
                if (result.getResponseCode().equals("1")) {
                    System.out.println(result.getResponseCode());
                    System.out.println("Successful Credit Card Transaction");
                    System.out.println(result.getAuthCode());
                    System.out.println(result.getTransId());
                }
                else
                {
                    System.out.println("Failed Transaction"+result.getResponseCode());
                }
            }
            else
            {
                System.out.println("Failed Transaction:  "+response.getMessages().getResultCode());
            }
        }   

  	}
  	
	
	public void setItemDao(ItemDao itemDao) {
	    this.itemDao = itemDao;
	}
}
