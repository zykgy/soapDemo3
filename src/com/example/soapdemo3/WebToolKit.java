package com.example.soapdemo3;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public class WebToolKit {

	public static final String CATEGORIESSERVER_URL = "http://www.sandwalkstudio.com/administrator/components/com_vm_soa/services/VM_CategoriesService.php";
	public static final String PRODUCTSERVEL_URL = "http://www.sandwalkstudio.com/administrator/components/com_vm_soa/services/VM_ProductService.php";
	public static final String CategoriesPicterusURL = "http://www.sandwalkstudio.com/components/com_virtuemart/shop_image/category/";
	
	// static final String CategoriesPicterusURL2
	// ="http://www.sandwalkstudio.com/components/com_virtuemart/shop_image/category/";
	public static final String ProductsPicterusURL = "http://www.sandwalkstudio.com/components/com_virtuemart/shop_image/product/";
	public static final String Login = "admin";
	public static final String password = "swad2012elg";
	public static String GETALLCATEGORIES = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
			+ "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vm=\"http://www.virtuemart.net/VM_Categories/\">"
			+ "<soapenv:Header/>"
			+ "<soapenv:Body>"
			+ "<vm:GetAllCategoriesRequest>"
			+ "<loginInfo>"
			+ "<login>%s</login>"
			+ "<password>%s</password>"
			+ "<lang>%s</lang>"
			+ "</loginInfo>"
			+ "<category_publish>%s</category_publish>"
			+ "</vm:GetAllCategoriesRequest>"
			+ "</soapenv:Body>"
			+ "</soapenv:Envelope>";
	public static String GETPRODUCTSFROMCATEGORY = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
			+ "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vm=\"http://www.virtuemart.net/VM_Product/\">"
			+ "<soapenv:Header/>"
			+ "<soapenv:Body>"
			+ "<vm:GetProductsFromCategoryRequest>"
			+ "<loginInfo>"
			+ "<login>%s</login>"
			+ "<password>%s</password>"
			+ "<lang>%s</lang>"
			+ "</loginInfo>"
			+ "<catgory_id>%d</catgory_id>"
			+ "<product_publish>%s</product_publish>"
			+ "<with_childs>%s</with_childs>"
			+ "</vm:GetProductsFromCategoryRequest>"
			+ "</soapenv:Body>"
			+ "</soapenv:Envelope>";
	
	public static final String SOAP_ACTION = "http://www.virtuemart.net/VM_Categories/GetAllCategories";
	public static final String SOAP_ACTION_GETPRODUCTSFROMCATEGORY ="http://www.virtuemart.net/VM_Product/GetProductsFromCategory";
	public static final String REQUEST_ENV_GETALLCATEGORIES = String.format(
			GETALLCATEGORIES, "admin", "swad2012elg", "?", "y");
	//public static final String REQUEST_ENV_GETPRODUCTSFROMCATEGORY =String.format(GETPRODUCTSFROMCATEGORY, "admin","swad2012elg","?","");

	public static String getRequestEnv(String request,Object ...args) {
		return String.format(request, args);
	}
	public static String CallWebService(String url, String soapAction,
			String envelope) {

		final DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpParams params = httpClient.getParams();
		HttpConnectionParams.setConnectionTimeout(params, 10000);
		HttpConnectionParams.setSoTimeout(params, 15000);

		HttpProtocolParams.setUseExpectContinue(httpClient.getParams(), true);

		HttpPost httppost = new HttpPost(url);

		// httppost.setHeader("User-Agent",
		// "Apache-HttpClient/4.1.1 (java 1.5)");
		httppost.setHeader("SOAPAction", soapAction);
		httppost.setHeader("Content-Type", "text/xml;charset=utf-8");
		// httppost.setHeader("Accept-Encoding","zip");

		// httppost.setHeader("Content-Length",
		// String.valueOf(envelope.length()));
		// httppost.setHeader("Connection","Keep-Alive");
		// httppost.setHeader("Host","www.sandwalkstudio.com");

		String responseString = "";
		try {
			HttpEntity entity = new StringEntity(envelope);
			httppost.setEntity(entity);

			ResponseHandler<String> rh = new ResponseHandler<String>() {

				@Override
				public String handleResponse(HttpResponse response)
						throws ClientProtocolException, IOException {
					HttpEntity entity = response.getEntity();

					StringBuffer out = new StringBuffer();
					byte[] b = EntityUtils.toByteArray(entity);

					out.append(new String(b, 0, b.length));
					return out.toString();
				}
			};
			responseString = httpClient.execute(httppost, rh);
		} catch (Exception e) {

			// Log.v("exception", e.toString());
			System.out.println(e.toString());
		}
		httpClient.getConnectionManager().shutdown();
		// Log.v("responseString==>", responseString);
		return responseString;
	}

}
