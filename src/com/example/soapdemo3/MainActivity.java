package com.example.soapdemo3;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import com.example.soapdemo3.Constants.Extra;
import com.fedorvlasov.lazylist.ListActivity;
import com.nostra13.universalimageloader.utils.L;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	private static final String TAG = "testPullParseService";
	private Button btn;
	private ArrayList<Category> categories;
	private ArrayList<Produit> produits;
	File testImageOnSdCard;

	private static final String TEST_FILE_NAME = "Universal Image Loader @#&=+-_.,!()~'%20.png";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.button1);

		testImageOnSdCard = new File("/mnt/sdcard", TEST_FILE_NAME);
		if (!testImageOnSdCard.exists()) {
			copyTestImageToSdCard(testImageOnSdCard);
		}

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// testWebservice();

				new MyAsyncThsk().execute(null, null, null);

			}
		});
	}

	private void testWebservice() {
		String response = WebToolKit.CallWebService(
				WebToolKit.PRODUCTSERVEL_URL,
				WebToolKit.SOAP_ACTION_GETPRODUCTSFROMCATEGORY, WebToolKit
						.getRequestEnv(WebToolKit.GETPRODUCTSFROMCATEGORY,
								"admin", "swad2012elg", "?", 19, "y", "y"));
		InputStream is = new ByteArrayInputStream(response.getBytes());
		try {
			if (Environment.getExternalStorageState().equals(
					Environment.MEDIA_MOUNTED)) {
				File sdCardDir = Environment.getExternalStorageDirectory();// 获取SDCard目录
				File saveFile = new File(sdCardDir, "text.xml");
				FileOutputStream outStream = new FileOutputStream(saveFile);
				outStream.write(response.getBytes());
				outStream.close();
				Log.i("HHHH", "成功写进文件");
			}

			produits = PullParseService.GetProductsFromCategory(is);
			ArrayList<String> childCategorysImageUrl = new ArrayList<String>();
			for (Produit produit : produits) {
				
				if (produit.getHas_childs()!=0) {
					childCategorysImageUrl.add(produit.getImage());
					//System.out.println(produit.getImage());
					System.out.println(produit.toString());
				}
				//System.out.println(produit.toString());
			}
		} catch (Exception e) {
			// TODO: handle exceptione
			e.printStackTrace();
		}
	}

	private class MyAsyncThsk extends AsyncTask<String, Integer, Double> {

		@Override
		protected Double doInBackground(String... params) {
			String resp = WebToolKit.CallWebService(
					WebToolKit.CATEGORIESSERVER_URL, WebToolKit.SOAP_ACTION,
					WebToolKit.REQUEST_ENV_GETALLCATEGORIES);
			InputStream is = new ByteArrayInputStream(resp.getBytes());
			try {
				// categories = PullParseService.getAllCategorys(is);
				//
				// Intent intent = new Intent(MainActivity.this,
				// ImageListActivity.class);
				// //intent.putExtra(Extra.IMAGES, IMAGES);
				// Bundle b =new Bundle();
				// b.putParcelableArrayList(Extra.IMAGES, categories);
				// intent.putExtra("categorie", b);
				// startActivity(intent);

				testWebservice();

				// Intent i =new Intent(MainActivity.this,ListActivity.class);
				// Bundle b =new Bundle();
				// b.putParcelableArrayList("Categorys", categories);
				//
				// i.putExtra("categorie", b);
				// startActivity(i);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onPostExecute(Double result) {
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}

	}

	private void copyTestImageToSdCard(final File testImageOnSdCard) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					InputStream is = getAssets().open(TEST_FILE_NAME);
					FileOutputStream fos = new FileOutputStream(
							testImageOnSdCard);
					byte[] buffer = new byte[8192];
					int read;
					try {
						while ((read = is.read(buffer)) != -1) {
							fos.write(buffer, 0, read);
						}
					} finally {
						fos.flush();
						fos.close();
						is.close();
					}
				} catch (IOException e) {
					L.w("Can't copy test image onto SD card");
				}
			}
		}).start();
	}

}
