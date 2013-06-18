package com.example.soapdemo3;

import java.io.InputStream;
import java.util.ArrayList;


import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public class PullParseService {

	private static final String TAG = "XMLParse";

	public static ArrayList<Produit> GetProductsFromCategory(
			InputStream inputStream) throws Exception {
		ArrayList<Produit> produits = null;
		Produit produit = null;
		XmlPullParser parser = Xml.newPullParser();
		parser.setInput(inputStream, "UTF-8");

		int event = parser.getEventType();// 产生第一个事件
		while (event != XmlPullParser.END_DOCUMENT) {
			switch (event) {
			case XmlPullParser.START_DOCUMENT:
				produits = new ArrayList<Produit>();
				break;
			case XmlPullParser.START_TAG:
				if ("Produit".equals(parser.getName())) {
					produit = new Produit();
					//Log.i(TAG, "produit init!");
				}
				if (produit != null) {
					if ("id".equals(parser.getName())) {
						produit.setId(Integer.parseInt(parser.nextText()));
						//Log.i(TAG, "produit setId");
					}
					if ("name".equals(parser.getName())) {
						produit.setName(parser.nextText());
						//Log.i(TAG, "produit setName");
					}
					if ("product_sku".equals(parser.getName())) {
						produit.setProduct_sku(parser.nextText());
						//Log.i(TAG, "produit setProduct_sku");
					}
					if ("product_sales".equals(parser.getName())) {
						produit.setProduct_sales(Integer.parseInt(parser
								.nextText()));
						//Log.i(TAG, "setProduct_sales");
					}
					if ("price".equals(parser.getName())) {
						produit.setPrice(Float.parseFloat(parser.nextText()));
						//Log.i(TAG, "setPrice");
					}
					if ("discount".equals(parser.getName())) {
						produit.setDiscount(Integer.parseInt(parser.nextText()));
						//Log.i(TAG, "setDiscount");
					}
					if ("discount_is_percent".equals(parser.getName())) {
						produit.setDiscount_is_percent(Integer.parseInt(parser
								.nextText()));
						//Log.i(TAG, "setDiscount_is_percent");
					}
					if ("description".equals(parser.getName())) {
						produit.setDescription(parser.nextText());
						//Log.i(TAG, "setDescription");
					}
					if ("bigdescription".equals(parser.getName())) {
						produit.setBigdescription(parser.nextText());
						//Log.i(TAG, "setBigdescription");
					}
					if ("image".equals(parser.getName())) {
						produit.setImage(parser.nextText());
						//Log.i(TAG, "setImage");
					}
					if ("fullimage".equals(parser.getName())) {
						produit.setFullimage(parser.nextText());
						//Log.i(TAG, "setFullimage");
					}
					if ("quantity".equals(parser.getName())) {
						produit.setQuantity(Integer.parseInt(parser.nextText()));
						//Log.i(TAG, "setQuantity");
					}
					if ("parent_produit_id".equals(parser.getName())) {
						produit.setParent_produit_id(Integer.parseInt(parser
								.nextText()));
						//Log.i(TAG, "setParent_produit_id");
					}
					if ("has_childs".equals(parser.getName())) {
						produit.setHas_childs(Integer.parseInt(parser
								.nextText()));
						//Log.i(TAG, "setHas_childs");
					}
					if ("childs_id".equals(parser.getName())) {
						produit.setChilds_id(parser.nextText());
						//Log.i(TAG, "setChilds_id");
					}
					if ("atribute".equals(parser.getName())) {
						produit.setAtribute(parser.nextText());
						//Log.i(TAG, "setAtribute");
					}
					if ("atribute_value".equals(parser.getName())) {
						produit.setAtribute_value(parser.nextText());
						//Log.i(TAG, "setAtribute_value");
					}
					if ("product_publish".equals(parser.getName())) {
						produit.setProduct_publish(parser.nextText());
						//Log.i(TAG, "setProduct_publish");
					}
					if ("product_weight".equals(parser.getName())) {
						produit.setProduct_weight(Float.parseFloat(parser
								.nextText()));
						//Log.i(TAG, "setProduct_weight");
					}
					if ("product_weight_uom".equals(parser.getName())) {
						produit.setProduct_weight_uom(parser.nextText());
						//Log.i(TAG, "setProduct_weight_uom");
					}
					if ("product_length".equals(parser.getName())) {
						produit.setProduct_length(Float.parseFloat(parser
								.nextText()));
						//Log.i(TAG, "setProduct_length");
					}
					if ("product_width".equals(parser.getName())) {
						produit.setProduct_width(Float.parseFloat(parser
								.nextText()));
						//Log.i(TAG, "setProduct_width");
					}
					if ("product_heigh".equals(parser.getName())) {
						produit.setProduct_height(Float.parseFloat(parser
								.nextText()));
						//Log.i(TAG, "setProduct_height");
					}
					if ("product_lwh_uom".equals(parser.getName())) {
						produit.setProduct_lwh_uom(parser.nextText());
						//Log.i(TAG, "setProduct_lwh_uom");
					}
					if ("product_unit".equals(parser.getName())) {
						produit.setProduct_unit(parser.nextText());
						//Log.i(TAG, "setProduct_unit");
					}
					if ("product_packaging".equals(parser.getName())) {
						produit.setProduct_packaging(Integer.parseInt(parser
								.nextText()));
						//Log.i(TAG, "setProduct_packaging");
					}
					if ("product_url".equals(parser.getName())) {
						produit.setProduct_url(parser.nextText());
						//Log.i(TAG, "setProduct_url");
					}
					if ("custom_attribute".equals(parser.getName())) {
						produit.setCustom_attribute(parser.nextText());
						//Log.i(TAG, "setCustom_attribute");
					}
					if ("product_available_date".equals(parser.getName())) {
						produit.setProduct_available_date(Integer
								.parseInt(parser.nextText()));
						//Log.i(TAG, "setProduct_available_date");
					}
					if ("product_availability".equals(parser.getName())) {
						produit.setProduct_availability(parser.nextText());
						//Log.i(TAG, "setProduct_availability");
					}
					if ("product_special".equals(parser.getName())) {
						produit.setProduct_special(parser.nextText());
						//Log.i(TAG, "setProduct_special");
					}
					if ("child_options".equals(parser.getName())) {
						produit.setChild_options(parser.nextText());
						//Log.i(TAG, "setChild_options");
					}
					if ("quantity_options".equals(parser.getName())) {
						produit.setQuantity_options(parser.nextText());
						//Log.i(TAG, "setQuantity_options");
					}
					if ("product_discount_id".equals(parser.getName())) {
						produit.setProduct_discount_id(Integer.parseInt(parser
								.nextText()));
						//Log.i(TAG, "setProduct_discount_id");
					}
					if ("product_tax_id".equals(parser.getName())) {
						produit.setProduct_tax_id(Integer.parseInt(parser
								.nextText()));
						//Log.i(TAG, "setProduct_tax_id");
					}
					if ("child_option_ids".equals(parser.getName())) {
						produit.setChild_option_ids(parser.nextText());
						//Log.i(TAG, "setChild_option_ids");
					}
					if ("product_order_levels".equals(parser.getName())) {
						produit.setProduct_order_levels(parser.nextText());
						//Log.i(TAG, "setProduct_order_levels");
					}
					if ("product_categories".equals(parser.getName())) {
						produit.setProduct_categories(parser.nextText());
						//Log.i(TAG, "setProduct_categories");
					}
					if ("product_currency".equals(parser.getName())) {
						produit.setProduct_currency(parser.nextText());
						//Log.i(TAG, "setProduct_currency");

					}
					if ("manufacturer_id".equals(parser.getName())) {
						produit.setManufacturer_id(Integer.parseInt(parser
								.nextText()));
						//Log.i(TAG, "setManufacturer_id");
					}
					if ("vendor_id".equals(parser.getName())) {
						produit.setVendor_id(Integer.parseInt(parser.nextText()));
						//Log.i(TAG, "setVendor_id");
					}
					if ("shopper_group_id".equals(parser.getName())) {
						//String shopper_group_id = parser.nextText();
						produit.setShopper_group_id(parser.nextText());
						//Log.i(TAG, "setShopper_group_id");
					}
				}
				break;
			case XmlPullParser.END_TAG:
				if ("Produit".equals(parser.getName())) {// 判断结束标签元素是否是produit
					produits.add(produit);// 将produit添加到produits集合
					produit = null;
				}
				break;
			default:
				break;
			}
			event = parser.next();// 进入下一个元素并触发相应事件
		}// end while
		return produits;
	}

	public static ArrayList<Category> getAllCategorys(InputStream inputStream)
			throws Exception {
		ArrayList<Category> categorys = null;
		Category category = null;
		XmlPullParser parser = Xml.newPullParser();
		parser.setInput(inputStream, "UTF-8");

		int event = parser.getEventType();// 产生第一个事件
		while (event != XmlPullParser.END_DOCUMENT) {
			switch (event) {
			case XmlPullParser.START_DOCUMENT:// 判断当前事件是否是文档开始事件
				categorys = new ArrayList<Category>();// 初始化books集合
				break;
			case XmlPullParser.START_TAG:// 判断当前事件是否是标签元素开始事件
				if ("Categorie".equals(parser.getName())) {
					category = new Category();
				}

				if (category != null) {
					if ("id".equals(parser.getName())) {
						category.setId(Integer.parseInt(parser.nextText()));
					} else if ("name".equals(parser.getName())) {
						category.setName(parser.nextText());
					} else if ("description".equals(parser.getName())) {
						category.setDescription(parser.nextText());
					} else if ("parentcat".equals(parser.getName())) {
						category.setParentcat(Integer.parseInt(parser
								.nextText()));
					} else if ("image".equals(parser.getName())) {
						category.setImage(parser.nextText());
					} else if ("fullimage".equals(parser.getName())) {
						category.setFullimage(parser.nextText());
					} else if ("numberofproducts".equals(parser.getName())) {
						category.setNumberofproducts(Integer.parseInt(parser
								.nextText()));
					} else if ("category_publish".equals(parser.getName())) {
						category.setCategory_publish(parser.nextText());
					} else if ("category_browsepage".equals(parser.getName())) {
						category.setCategory_browsepage(parser.nextText());
					} else if ("category_flypage".equals(parser.getName())) {
						category.setCategory_flypage(parser.nextText());
					} else if ("products_per_row".equals(parser.getName())) {
						category.setProducts_per_row(Integer.parseInt(parser
								.nextText()));
					}
				}
				break;
			case XmlPullParser.END_TAG:// 判断当前事件是否是标签元素结束事件
				if ("Categorie".equals(parser.getName())) {// 判断结束标签元素是否是category
					categorys.add(category);// 将category添加到categorys集合
					category = null;
				}
				break;
			}
			event = parser.next();// 进入下一个元素并触发相应事件
		}// end while
		return categorys;
	}

}
