package com.isp.wsrr.utility;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WSRRUtility {

	public static void main(String[] args) throws Exception {
		// Initialize the config variables for processing from the command line

		WSRRUtility wsrrutility=new WSRRUtility();
		
		//11012017 vedi note per 11012017_branch

		String url = "https://WIN-MT67KKLQ7LO:9443/WSRR/8.5";
		String user = "gabriele";
		String password = "viviana";

		System.out.println("azz");
		String name=null;
		JSONArray jsa=new JSONArray();

		//SLD - input_00_CICS  1d2b071d-1db2-4291.878b.ee3e08ee8bd7

		//sld 13c7c513-3bd7-47a5.b0da.e14503e1dadd - 46ba3546-780e-4e8f.b948.cf9d1fcf4878 consumer CONSUMATORE


		System.out.println(">> "+wsrrutility.getSLAassociatedToSLDExtended("CONSUMATORE_", "00","13c7c513-3bd7-47a5.b0da.e14503e1dadd",url, user, password));

		int gg=0;


		String qqq= wsrrutility.getGenericObjectByNameAndPrimaryType("SLD%20-%20ALPA_00_CICS",
				"http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel%23ServiceLevelDefinition",
				url, user, password);

		qqq= wsrrutility.getGenericObjectByNameAndPrimaryTypeExtended("SLD%20-%20ALPA_00_CICS",
				"http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel%23ServiceLevelDefinition",
				url, user, password);


		int g=0;

		String 
		Pippo=wsrrutility.checkClassification("1d2b071d-1db2-4291.878b.ee3e08ee8bd7","SLAActive",url,user,password);




		String[] SLAactivateTransaction = {
		"http://www.ibm.com/xmlns/prod/serviceregistry/lifecycle/v6r3/LifecycleDefinition%23ActivateSLA" };

		wsrrutility.changeGovernanceState("3f13353f-132f-4ff8.9b87.c2384dc28710", SLAactivateTransaction,
				url, user, password);



		Runtime.getRuntime().exit(0);


		StringBuffer sb=new StringBuffer();
		String sldProvider = sb.append("SLD%20-%20").append("input").append("_").append("00")
				.append("_").append("CICS").toString();

		String bsrURISLD = wsrrutility.getGenericObjectByNameAndPrimaryType(sldProvider,
				"http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel%23ServiceLevelDefinition",
				url, user, password);



		//String endpointData = wsrrutility.getEndpointInfo("AMICO", "00", "CICS", "Application", url,
		//		user, password);
		//40725c40-a7fc-4c11.9f9a.b3245ab39aa4 46ba3546-780e-4e8f.b948.cf9d1fcf4878

		//	boolean result=wsrrutility.isSLDConsumedByService("j1000", "00","40725c40-a7fc-4c11.9f9a.b3245ab39aa4",url, user, password);


		//bbba5abb-0ae3-432f.a1b8.501e5850b80e
		//FINN0
		//00
		//http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel%23ApplicationVersion

		System.out.println(">>> "+wsrrutility.getSLAassociatedToSLDWithPrimaryTypeExtended("FINN0", "00","http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel%23ApplicationVersion","bbba5abb-0ae3-432f.a1b8.501e5850b80e",url, user, password));





		//////////////////////////
		//jsa = new JSONArray(endpointData);
		//String bsrURIEndpoint = WSRRUtility.getObjectValueFromJSONArrayData((JSONArray) jsa.get(0), "sm63_DATA_PRIMO_UTILIZZO");
		//////////////////////////

		int ea=0;

		http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel%23BusinessApplication

			//jsa=wsrrutility.getObjectPropertiesData("","&p1=name", url, user, password);


			//jsa=wsrrutility.getEndpointInfoFromBsrUriCatalogAndEnvironment("dc9e1bdc-b933-43e3.93c1.bdff9abdc158", "Produzione", url, user, password);


			System.out.println(jsa);


		String ggg=wsrrutility.getGenericObjectByNameAndVersionAndPrimaryTypeExtended("0M",
				"00",
				"http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel%23ApplicationVersion",
				url, user, password);

		int gt=0;

		String kkk=WSRRUtility.getObjectValueFromJSONArrayData(
				(JSONArray) jsa.get(0), "sm63_DATA_ULTIMO_UTILIZZO");

		int k2=0;

		jsa=wsrrutility.getConsumersFromSLAGeneral("70bcd170-ee2b-4b35.927a.bfd1e2bf7a3c", url, user, password);


		int k=0;

		System.out.println(jsa);
		//name=getObjectValueFromJSONArrayEndpointData((JSONArray) jsa.get(0), "gep63_ATTIVATO_IN_PROD");
		//name=getObjectValueFromJSONArrayEndpointData((JSONArray) jsa.get(0), "name");

		jsa=wsrrutility.getAssociatedInterfaces("LOOKUPWSRR","00",url,user,password);

		name=getObjectValueFromJSONArrayData((JSONArray) jsa.get(0), "name");

		String name1=WSRRUtility.unescape(name);

		System.out.println(name1);
		/**
		System.out.println(">>-------------------------------------------------------------------");
		res = wsrrutility.getConsumersFromSLA("d81365d8-af29-490f.a935.24ed66243585", url, user, password);

		System.out.println("Consumer - " + res);

		res = wsrrutility.getSLDFromSLA("d81365d8-af29-490f.a935.24ed66243585", url, user, password);

		System.out.println("SLD - " + res);

		String provider = wsrrutility.getProviderFromSLD(res, url, user, password);

		System.out.println("Provider - " + provider);

		res = wsrrutility.getServiceVersionClassification(provider, url, user, password);

		System.out.println("Type - " + res);

		res = wsrrutility.getOwningOrganizationFromGenericObjectByBsrUri(provider, url, user, password);

		if (res != null) {
			res = wsrrutility.getSSAFromAcronimo(res, url, user, password);

			System.out.println("SSA - " + res);
		} else {

			System.out.println("SSA - " + " NON PRESENTE");
		}

		 **/
		int a = 0;
		a = a + 1;
		/**
		 * System.out.println(wsrrutility.
		 * getGenericObjectByNameAndVersionAndPrimaryType("estate", "",
		 * "http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ALEModel%23Organization",
		 * url, user, password));
		 * System.out.println(wsrrutility.getGenericObjectByNameAndPrimaryType(
		 * "estate",
		 * "http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ALEModel%23Organization",
		 * url, user, password)); //esempio creazione Organizzazione String
		 * xmlOrg=wsrrenvelopes.createOrganizationXMLData("THORGANIZATION4");
		 * String response=wsrrutility.createWSRRGenericObject(xmlOrg, "POST",
		 * url, user, password); System.out.println(response);
		 * 
		 * wsrrutility.deleteWSRRObject("fe7e88fe-e57e-4e90.b3aa.9ac90d9aaab2",
		 * url, user, password);
		 * 
		 * //xmlOrg=wsrrenvelopes.createOrganizationXMLDataExtended("KKKKK",
		 * "ZZZZZZZZ", null); //d7f160d7-939f-4f07.8859.f98fe8f9592e
		 * 
		 * xmlOrg=wsrrenvelopes.createOrganizationXMLDataExtended("VVVVVVVv",
		 * "AAAAAAAAA", "d7f160d7-939f-4f07.8859.f98fe8f9592e");
		 * 
		 * response=wsrrutility.createWSRRGenericObject(xmlOrg, "POST", url,
		 * user, password); System.out.println(response);
		 * 
		 * this.
		 * 
		 **/

		/**
		 * wsrrutility.serviceVersionwithNoOwningOrganization("SHOST", true,
		 * url, user, password);
		 * 
		 * //wsrrutility.getGenericObjectByName("DIECI", url, user, password);
		boolean result=wsrrutility.isSLDConsumedByService("DIECI", "00",
		 * "e9475ae9-cfc7-4712.9f8e.5d6adc5d8e31",url, user, password);
		 * System.out.println(result);
		 * 
		 * System.out.println(wsrrutility.getSLAAssociatedToSLD("DIECI", "00",
		 * "e9475ae9-cfc7-4712.9f8e.5d6adc5d8e31", url, user, password));
		 * System.out.println(wsrrutility.getSLAAssociatedToSLD("DIECI", "00",
		 * "98d59998-78a1-4167.a4d1.8e1ab88ed132", url, user, password));
		 * String[] transistions={
		 * "http://www.ibm.com/xmlns/prod/serviceregistry/lifecycle/v6r3/LifecycleDefinition%23RequestSLA"
		 * ,
		 * "http://www.ibm.com/xmlns/prod/serviceregistry/lifecycle/v6r3/LifecycleDefinition%23ApproveSLARequest"
		 * }; //wsrrutility.changeGovernanceState(
		 * "01aafc01-df70-406d.b092.2945b42992bf", transistions, url, user,
		 * password); String bsrURI=wsrrutility.getEndpointInfo("FORNITORE",
		 * "00", "REST", "Application", url, user, password);
		 * System.out.println("endpoint Info "+bsrURI); String
		 * organization=wsrrutility.
		 * getOrganizationFromGenericObjectByNameAndVersion("LOOKUPWSRR", "00",
		 * url, user, password); System.out.println(organization); //boolean
		 * updateBsrURI=wsrrutility.updateSinglePropertyXMLFormat(
		 * "d1d31bd1-ca02-426d.8590.1588d51590e0", "gep63_DATA_PRIMO_UTILIZZO",
		 * "IERI", url, user, password); boolean
		 * updateBsrURI=wsrrutility.updateSinglePropertyXMLFormat(
		 * "6f76546f-c30f-4f59.8c9d.16e66b169d86", "gep63_DATA_ULTIMO_UTILIZZO",
		 * "20160615", url, user, password); System.out.println(updateBsrURI);
		 * //updateBsrURI=wsrrutility.updateSinglePropertyJSONFormat(
		 * "01aafc01-df70-406d.b092.2945b42992bf", "gpx63_RUNTIMEE", "N", url,
		 * user, password); System.out.println(updateBsrURI);
		 * wsrrutility.getGenericObjectByNameAndPrimaryType(
		 * "SLD - FORNITORE_00_REST",
		 * "http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel%23ServiceLevelDefinition",
		 * url, user, password);
		 * 
		 * String[] SLDsubscribable = {
		 * "http://www.ibm.com/xmlns/prod/serviceregistry/lifecycle/v6r3/LifecycleDefinition%23ProposeSpecification",
		 * "http://www.ibm.com/xmlns/prod/serviceregistry/lifecycle/v6r3/LifecycleDefinition%23ApproveSpecification"
		 * };
		 * 
		 * wsrrutility.changeGovernanceState(
		 * "46ba3546-780e-4e8f.b948.cf9d1fcf4878", SLDsubscribable, url, user,
		 * password);
		 * 
		 * System.out.println(wsrrutility.updateRelationShip(
		 * "1a58301a-ed4d-4df0.b849.6db6886d492f", "gep63_consumes",
		 * "e975f8e9-3c87-471e.a2e0.d6d5fcd6e0c8", url, user, password));
		 * 
		 * wsrrutility.getEndpointInfo("FORNITORE", "00", "REST", "Application",
		 * url, user, password);
		 * 
		 * 
		 * 
		 * // SSA_GAB
		 * 
		 * String qui=
		 * wsrrutility.getPropertyValueFromGenericObjectByName("SSA_GAB",
		 * "&p1=description", url, user, password);
		 * System.out.println("ciao"+WSRRUtility.extractPropertyValue(qui)+"io")
		 * ; //e9475ae9-cfc7-4712.9f8e.5d6adc5d8e3
		 * //98d59998-78a1-4167.a4d1.8e1ab88ed132
		 * //System.out.println(wsrrutility.getGenericObjectByNameAndPrimaryType
		 * ("THORGANIZATION2",
		 * "http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ALEModel%23Organization"
		 * ,url, user, password)); System.out.println(wsrrutility.
		 * getChildOrganizationFromGenericObjectByName("SSA_GAB", url, user,
		 * password));
		 * 
		 * //wsrrutility.getGenericObjectByNameAndPrimaryType("SSA_GAB",
		 * "http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ALEModel%23Organization"
		 * ,url, user, password);
		 * 
		 * wsrrutility.checkSSAAndAcronimoRelationShip("ACRONIMO_GAB",
		 * "96b21496-67c3-4374.9b3a.72c777723a18",
		 * "e8061fe8-b827-47c9.a280.1e99e71e80f8", url, user, password);
		 **/
	}

	public static String aboutLib() {

		return "lib WSRREnvelopes & utility methods V3.0 September 2016";

		//aggiunta chiusure input stream in tutte le funzioni
		//creata nuova funzione checkSSAAndAcronimoRelationShipVerbose (il messsaggio ritorna verboso) stampe SSA
		//negli envelopes aggiunta la classificazione nella creazione della organizzazione createOrganizationXMLDataExtended
		//aggiunta funzione: existObjectByNameAndVersionAndPrimaryType
		//aggiunta getGenericObjectByNameAndPrimaryTypeExtended
		//aggiunta getGenericObjectByNameAndVersionAndPrimaryTypeExtended
		//aggiunta getManualMQEndpointInfo
	}

	private static String getValueFromJsonObject(JSONObject jso, String key) {

		String result = "";

		try {

			result = jso.getString(key);

		} catch (JSONException e) {

			e.printStackTrace();

		}

		return result;

	}

	public static String getObjectValueFromJSONArrayData(JSONArray jsa, String key){

		int i = 0;

		int elements = jsa.length();

		String current;

		JSONObject jso;

		String result = "";

		while (i < elements) {

			jso = jsa.getJSONObject(i);

			current = ((String) jso.get("name"));

			if (current.equals(key)) {

				try {

					current = (String) jso.get("value");

				} catch (Exception ex) {

					current = ""; // @TODO eccezione?

					// throw new LIBLKPWSRRTEException(new
					// StringBuffer().append(Messages.ERROR_10).append(key).toString());

				}

				result = current;

				break;

			}

			i++;

		}

		//[[{"name":"name","value":"SLA - CONSUMATORE2 \u202a(00)\u202c"}]]

		return result.replaceAll("\\P{Print}", "");

	}


	public String getGenericObjectByNameAndVersionAndPrimaryType(String name, String version, String primaryType,
			String baseURL, String user, String password) {

		// Create the variable to return
		String bsrURI = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%'%20and%20@primaryType='%PRIMARYTYPE%']&p1=bsrURI";

		if (version == null || version.length() == 0)
			version = "00";

		query = query.replaceAll("%CATALOGNAME%", name);
		query = query.replaceAll("%VERSION%", version);
		query = query.replaceAll("%PRIMARYTYPE%", primaryType);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				bsrURI = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (bsrURI != null && bsrURI.equals("[]"))
			bsrURI = null;

		if (bsrURI != null) {
			JSONArray jsa = new JSONArray(bsrURI);
			bsrURI = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
			if (bsrURI != null) {
				bsrURI = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
			}
		}
		return bsrURI;

	}

	public String getGenericObjectByNameAndVersionAndPrimaryTypeExtended(String name, String version, String primaryType,
			String baseURL, String user, String password) {

		// Create the variable to return
		String bsrURI = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%'%20and%20@primaryType='%PRIMARYTYPE%']&p1=bsrURI";

		if (version == null || version.length() == 0)
			version = "00";

		query = query.replaceAll("%CATALOGNAME%", name);
		query = query.replaceAll("%VERSION%", version);
		query = query.replaceAll("%PRIMARYTYPE%", primaryType);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				bsrURI = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			bsrURI=">>**ERROR**>>"+e.getMessage();
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (bsrURI != null && !bsrURI.contains(">>**ERROR**>>")) {

			if (bsrURI != null && bsrURI.equals("[]"))
				bsrURI = null;

			if (bsrURI != null) {
				JSONArray jsa = new JSONArray(bsrURI);
				bsrURI = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
				if (bsrURI != null) {
					bsrURI = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
				}
			}
		}
		return bsrURI;

	}

	public boolean existObjectByNameAndVersionAndPrimaryType(String name, String version, String primaryType,
			String baseURL, String user, String password) {

		// Create the variable to return
		boolean result=false;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%'%20and%20@primaryType='%PRIMARYTYPE%']&p1=bsrURI";

		if (version == null || version.length() == 0)
			version = "00";

		query = query.replaceAll("%CATALOGNAME%", name);
		query = query.replaceAll("%VERSION%", version);
		query = query.replaceAll("%PRIMARYTYPE%", primaryType);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				result=true;
			} else {
				result=false;
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}


		return result;

	}



	public String getSLAassociatedToSLDExtended(String consumerName, String consumerVersion, String bsrURISLDProvider,
			String baseURL, String user, String password) {

		// Create the variable to return
		String bsrURI = null;
		String result=null;
		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%']/gep63_consumes(.)&p1=bsrURI";		

		if (consumerVersion == null || consumerVersion.length() == 0)
			consumerVersion = "00";

		query = query.replaceAll("%CATALOGNAME%", consumerName);
		query = query.replaceAll("%VERSION%", consumerVersion);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				bsrURI = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			bsrURI=">>**ERROR**>>"+e.getMessage();
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}


		if (bsrURI != null && !bsrURI.contains(">>**ERROR**>>")) {
			if (bsrURI !=null && bsrURI.equals("[]")) result=null;

			else {
				JSONArray jsa = new JSONArray(bsrURI);
				JSONArray jsae = null;
				JSONArray jsae1 = null;
				JSONObject jso = null;
				String bsrURICurrent = null;
				String bsrURISLD = null;
				int i = jsa.length();
				int j = 0;
				while (i > j) {

					try {

						String query1 = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@bsrURI='%BSRURI%']/gep63_agreedEndpoints(.)&p1=bsrURI";

						jsae = (JSONArray) jsa.getJSONArray(j);
						jso = (JSONObject) jsae.getJSONObject(0);

						bsrURICurrent = (String) jso.get("value"); //uri SSA

						query1=query1.replaceAll("%BSRURI%", bsrURICurrent);

						try {
							StringBuffer sb1 = new StringBuffer();
							sb1.append(baseURL).append(query1);
							URL url = new URL(sb1.toString());
							urlConnection = (HttpURLConnection) url.openConnection();
							urlConnection.setRequestMethod("GET");
							urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
							urlConnection.setUseCaches(false);

							if (user != null && password != null) {

								String userPassword = user + ":" + password;

								String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

								urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
							}

							int responsecode = urlConnection.getResponseCode();
							if (responsecode == 200 || (responsecode == 201)) {
								InputStream is = null;
								is = urlConnection.getInputStream();
								int ch;
								sb1.delete(0, sb1.length());
								while ((ch = is.read()) != -1) {
									sb1.append((char) ch);
								}
								bsrURI = sb1.toString();
								is.close();
							} else {
								BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
								StringBuffer stringBuffer = new StringBuffer();
								String line = null;
								while (null != (line = reader.readLine())) {
									stringBuffer.append(line);
								}
								reader.close();
							}
							urlConnection.disconnect();
						} catch (Exception e) {
							bsrURI=">>**ERROR**>>"+e.getMessage();
							e.printStackTrace();
						}

						finally {
							if (urlConnection != null)
								urlConnection.disconnect();
						}

						
						if (bsrURI != null && !bsrURI.contains(">>**ERROR**>>")) {
							
						jsae1=new JSONArray(bsrURI);

						bsrURISLD=WSRRUtility.getObjectValueFromJSONArrayData((JSONArray)jsae1.get(0), "bsrURI");
					
						if (bsrURISLD != null && bsrURISLD.equals(bsrURISLDProvider)) {
							result=bsrURICurrent;

							break;
						}

					}

					} catch (Exception ex) {

					}

					j++;
				}

			} }

		return result;

	}


	///in progress per ora non usata
	public String getSLAassociatedToSLDExtended2(String slaName, String bsrURISLDProvider,
			String baseURL, String user, String password) {

		// Create the variable to return
		String bsrURI = null;
		String result=null;
		String sldURI=null;
		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[matches(@name,'%SLANAME%')]/gep63_agreedEndpoints(.)&p1=bsrURI";		

		query = query.replaceAll("%SLANAME%", slaName);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				bsrURI = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			result=">>**ERROR**>>"+e.getMessage();
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		JSONArray jsa = new JSONArray(bsrURI);
		JSONArray jsae = null;
		String bsrURICurrent = null;
		int i = jsa.length();
		int j = 0;
		while (i > j) {

			jsae = (JSONArray) jsa.getJSONArray(j);
			sldURI=WSRRUtility.getObjectValueFromJSONArrayData((JSONArray)jsae.get(0), "bsrURI");

			if (sldURI != null && sldURI.equals(bsrURISLDProvider)) {
				result=bsrURICurrent;			
				break;
			}

			j++;
		}

		//get associated SLA to SLD



		if (result != null && !result.contains(">>**ERROR**>>")) {
			if (result !=null && result.equals("[]")) result=null;
		}
		return result;

	}

	public String getSLAassociatedToSLDWithPrimaryTypeExtended(String consumerName, String consumerVersion,String primaryType, String bsrURISLDProvider,
			String baseURL, String user, String password) {

		// Create the variable to return
		String bsrURI = null;
		String result=null;
		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%'%20and%20@primaryType='%PRIMARYTYPE%']/gep63_consumes(.)&p1=bsrURI";	

		if (consumerVersion == null || consumerVersion.length() == 0)
			consumerVersion = "00";

		query = query.replaceAll("%CATALOGNAME%", consumerName);
		query = query.replaceAll("%VERSION%", consumerVersion);
		query = query.replaceAll("%PRIMARYTYPE%", primaryType);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				bsrURI = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			result=">>**ERROR**>>"+e.getMessage();
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		JSONArray jsa = new JSONArray(bsrURI);
		JSONArray jsae = null;
		JSONArray jsae1 = null;
		JSONObject jso = null;
		String bsrURICurrent = null;
		String bsrURISLD = null;
		int i = jsa.length();
		int j = 0;
		while (i > j) {


			//jsae = (JSONArray) jsa.getJSONArray(j);

			try {

				String query1 = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@bsrURI='%BSRURI%']/gep63_agreedEndpoints(.)&p1=bsrURI";

				jsae = (JSONArray) jsa.getJSONArray(j);
				jso = (JSONObject) jsae.getJSONObject(0);

				bsrURICurrent = (String) jso.get("value"); //uri SSA

				query1=query1.replaceAll("%BSRURI%", bsrURICurrent);

				try {
					StringBuffer sb1 = new StringBuffer();
					sb1.append(baseURL).append(query1);
					URL url = new URL(sb1.toString());
					urlConnection = (HttpURLConnection) url.openConnection();
					urlConnection.setRequestMethod("GET");
					urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
					urlConnection.setUseCaches(false);

					if (user != null && password != null) {

						String userPassword = user + ":" + password;

						String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

						urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
					}

					int responsecode = urlConnection.getResponseCode();
					if (responsecode == 200 || (responsecode == 201)) {
						InputStream is = null;
						is = urlConnection.getInputStream();
						int ch;
						sb1.delete(0, sb1.length());
						while ((ch = is.read()) != -1) {
							sb1.append((char) ch);
						}
						bsrURI = sb1.toString();
						is.close();
					} else {
						BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
						StringBuffer stringBuffer = new StringBuffer();
						String line = null;
						while (null != (line = reader.readLine())) {
							stringBuffer.append(line);
						}
						reader.close();
					}
					urlConnection.disconnect();
				} catch (Exception e) {
					result=">>**ERROR**>>"+e.getMessage();
					e.printStackTrace();
				}

				finally {
					if (urlConnection != null)
						urlConnection.disconnect();
				}

				jsae1=new JSONArray(bsrURI);

				bsrURISLD=WSRRUtility.getObjectValueFromJSONArrayData((JSONArray)jsae1.get(0), "bsrURI");


				if (bsrURISLD != null && bsrURISLD.equals(bsrURISLDProvider)) {
					result=bsrURICurrent;

					break;
				}
			} catch (Exception ex) {

			}

			j++;
		}

		if (result != null && !result.contains(">>**ERROR**>>")) {
			if (result !=null && result.equals("[]")) result=null;
		}
		return result;

	}

	public boolean isSLDConsumedByService(String consumerName, String consumerVersion, String bsrURISLDProvider,
			String baseURL, String user, String password) {

		// Create the variable to return
		String resultdata = null;
		boolean result = false;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%']/gep63_consumes(.)/gep63_agreedEndpoints(.)[exactlyClassifiedByAllOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel%23ServiceLevelDefinition')]&p1=bsrURI";

		if (consumerVersion == null || consumerVersion.length() == 0)
			consumerVersion = "00";

		query = query.replaceAll("%CATALOGNAME%", consumerName);
		query = query.replaceAll("%VERSION%", consumerVersion);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				resultdata = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		// [[{"value":"e9475ae9-cfc7-4712.9f8e.5d6adc5d8e31","name":"bsrURI"}],[{"value":"98d59998-78a1-4167.a4d1.8e1ab88ed132","name":"bsrURI"}]]
		JSONArray jsa = new JSONArray(resultdata);
		JSONArray jsae = null;
		JSONObject jso = null;
		String bsrURICurrent = null;
		int i = jsa.length();
		int j = 0;
		while (i > j) {
			jsae = (JSONArray) jsa.getJSONArray(j);
			try {
				jso = (JSONObject) jsae.getJSONObject(0);
				bsrURICurrent = (String) jso.get("value");

				if (bsrURICurrent.equals(bsrURISLDProvider)) {
					result = true;
					break;
				}
			} catch (Exception ex) {
				//
			}

			j++;
		}
		return result;

	}

	public boolean isSLDConsumedByServicePrimaryType(String consumerName, String consumerVersion, String primaryType,
			String bsrURISLDProvider, String baseURL, String user, String password) {

		// Create the variable to return
		String resultdata = null;
		boolean result = false;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%'%20and%20@primaryType='%PRIMARYTYPE%']/gep63_consumes(.)/gep63_agreedEndpoints(.)[exactlyClassifiedByAllOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel%23ServiceLevelDefinition')]&p1=bsrURI";

		if (consumerVersion == null || consumerVersion.length() == 0)
			consumerVersion = "00";

		query = query.replaceAll("%CATALOGNAME%", consumerName);
		query = query.replaceAll("%VERSION%", consumerVersion);
		query = query.replaceAll("%PRIMARYTYPE%", primaryType);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				resultdata = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		// [[{"value":"e9475ae9-cfc7-4712.9f8e.5d6adc5d8e31","name":"bsrURI"}],[{"value":"98d59998-78a1-4167.a4d1.8e1ab88ed132","name":"bsrURI"}]]
		JSONArray jsa = new JSONArray(resultdata);
		JSONArray jsae = null;
		JSONObject jso = null;
		String bsrURICurrent = null;
		int i = jsa.length();
		int j = 0;
		while (i > j) {
			jsae = (JSONArray) jsa.getJSONArray(j);
			try {
				jso = (JSONObject) jsae.getJSONObject(0);
				bsrURICurrent = (String) jso.get("value");

				if (bsrURICurrent.equals(bsrURISLDProvider)) {
					result = true;
					break;
				}
			} catch (Exception ex) {
				//
			}

			j++;
		}
		return result;

	}

	public void serviceVersionwithNoOwningOrganization(String tipo, boolean auth, String baseURL, String user,
			String password) {

		// Create the variable to return
		String resultdata = null;

		String type = "http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel%23" + tipo
				+ "ServiceVersion";

		// String
		// query="/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@primaryType='%CATALOGTYPE%'%20and%20@version='%VERSION%'%20and%20@primaryType='%PRIMARYTYPE%']/gep63_consumes(.)/gep63_agreedEndpoints(.)[exactlyClassifiedByAllOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel%23ServiceLevelDefinition')]&p1=bsrURI";

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@primaryType='%CATALOGTYPE%']&p1=bsrURI";

		query = query.replaceAll("%CATALOGTYPE%", type);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (auth) {

				if (user != null && password != null) {

					String userPassword = user + ":" + password;

					String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

					urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
				}

			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				resultdata = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		// [[{"value":"e9475ae9-cfc7-4712.9f8e.5d6adc5d8e31","name":"bsrURI"}],[{"value":"98d59998-78a1-4167.a4d1.8e1ab88ed132","name":"bsrURI"}]]
		JSONArray jsa = new JSONArray(resultdata);
		JSONArray jsae = null;
		JSONObject jso = null;
		String bsrURICurrent = null;
		int i = jsa.length();
		int j = 0;
		String owningOrg = null;
		while (i > j) {
			jsae = (JSONArray) jsa.getJSONArray(j);
			try {
				jso = (JSONObject) jsae.getJSONObject(0);
				bsrURICurrent = (String) jso.get("value");

				owningOrg = getOwningOrganizationFromGenericObjectByBsrUri(bsrURICurrent, baseURL, user, password);

				if (owningOrg == null) {

					System.out.println("Oggetto con BsrURI : " + bsrURICurrent + " di tipo : " + tipo
							+ "ServiceVersion NON HA Organizzazione associata");
				}

			} catch (Exception ex) {
				//
			}

			j++;
		}
		// return result;

	}

	public String getSLAAssociatedToSLD(String consumerName, String consumerVersion, String bsrURISLDProvider,
			String baseURL, String user, String password) {

		// Create the variable to return
		String resultdata = null;
		String bsrURI = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%']/gep63_consumes(.)[exactlyClassifiedByAllOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceProfileExtensions%23ServiceLevelAgreement')]&p1=bsrURI";
		String query1 = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@bsrURI='%BSRURI%']/gep63_agreedEndpoints(.)[exactlyClassifiedByAllOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel%23ServiceLevelDefinition')]&p1=bsrURI";

		if (consumerVersion == null || consumerVersion.length() == 0)
			consumerVersion = "00";

		query = query.replaceAll("%CATALOGNAME%", consumerName);
		query = query.replaceAll("%VERSION%", consumerVersion);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				resultdata = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		JSONArray jsa = new JSONArray(resultdata);
		JSONArray jsae = null;
		JSONObject jso = null;
		String bsrURICurrent = null;
		int i = jsa.length();
		int j = 0;
		while (i > j) {
			jsae = (JSONArray) jsa.getJSONArray(j);
			try {
				jso = (JSONObject) jsae.getJSONObject(0);
				bsrURI = (String) jso.get("value");
				String currentQuery = query1;
				resultdata = null;
				currentQuery = currentQuery.replaceAll("%BSRURI%", bsrURI);

				try {
					StringBuffer sb = new StringBuffer();
					sb.append(baseURL).append(currentQuery);
					URL url = new URL(sb.toString());
					urlConnection = (HttpURLConnection) url.openConnection();
					urlConnection.setRequestMethod("GET");
					urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
					urlConnection.setUseCaches(false);

					if (user != null && password != null) {

						String userPassword = user + ":" + password;

						String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

						urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
					}

					int responsecode = urlConnection.getResponseCode();
					if (responsecode == 200 || (responsecode == 201)) {
						InputStream is = null;
						is = urlConnection.getInputStream();
						int ch;
						sb.delete(0, sb.length());
						while ((ch = is.read()) != -1) {
							sb.append((char) ch);
						}
						resultdata = sb.toString();
						is.close();

						JSONArray jsa1 = new JSONArray(resultdata);
						JSONArray jsae1 = null;
						JSONObject jso1 = null;
						jsae1 = (JSONArray) jsa1.getJSONArray(0);
						jso1 = (JSONObject) jsae1.getJSONObject(0);
						bsrURICurrent = (String) jso1.get("value");

					} else {
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(urlConnection.getInputStream()));
						StringBuffer stringBuffer = new StringBuffer();
						String line = null;
						while (null != (line = reader.readLine())) {
							stringBuffer.append(line);
						}
						reader.close();
					}
					urlConnection.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}

				finally {
					if (urlConnection != null)
						urlConnection.disconnect();
				}

				if (bsrURICurrent != null && bsrURICurrent.equals(bsrURISLDProvider)) {

					break;

				} else
					bsrURI = null;
			} catch (Exception ex) {
				//
			}

			j++;
		}

		return bsrURI;
	}

	public boolean checkSSAAndAcronimoRelationShip(String acronimo, String bsrURIAcronimo, String bsrURISSA,
			String baseURL, String user, String password) {

		String resultdata = null;
		String bsrURI = null;
		boolean result = false;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[classifiedByAnyOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ALEModel%23Organization')/ale63_childOrganizations(.)[@name='%ACRONIMONAME%']]&p1=bsrURI";
		query = query.replaceAll("%ACRONIMONAME%", acronimo);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				resultdata = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		JSONArray jsa = new JSONArray(resultdata);
		JSONArray jsae = null;
		JSONObject jso = null;
		int i = jsa.length();
		int j = 0;
		boolean okOnDelete = true;
		boolean relation = false;

		if (i != 0) {

			while (i > j & okOnDelete) {
				jsae = (JSONArray) jsa.getJSONArray(j);
				try {
					jso = (JSONObject) jsae.getJSONObject(0);
					bsrURI = (String) jso.get("value");

					if (!bsrURI.equals(bsrURISSA)) {
						okOnDelete = deleteSpecificRelation(bsrURI, bsrURIAcronimo, "ale63_childOrganizations", baseURL,
								user, password);
					} else
						relation = true;
				} catch (Exception e) {
					e.printStackTrace();
					okOnDelete = false;
				}

				j++;
			}

			result = true;

			if (okOnDelete) {

				if (!relation) {

					result = updateRelationShip(bsrURISSA, "ale63_childOrganizations", bsrURIAcronimo, baseURL, user,
							password);
				}
			} else
				result = false;

		}

		else {
			// ssa & acronimo present without relation particular case
			result = updateRelationShip(bsrURISSA, "ale63_childOrganizations", bsrURIAcronimo, baseURL, user, password);

		}

		return result;
	}


	public String checkSSAAndAcronimoRelationShipVerbose(String acronimo, String bsrURIAcronimo, String bsrURISSA,
			String baseURL, String user, String password) {

		String resultdata = null;
		String bsrURI = null;
		boolean result = false;
		String message="";

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[classifiedByAnyOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ALEModel%23Organization')/ale63_childOrganizations(.)[@name='%ACRONIMONAME%']]&p1=bsrURI";
		query = query.replaceAll("%ACRONIMONAME%", acronimo);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				resultdata = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		JSONArray jsa = new JSONArray(resultdata);
		JSONArray jsae = null;
		JSONObject jso = null;
		int i = jsa.length();
		int j = 0;
		boolean okOnDelete = true;
		boolean relation = false;

		if (i != 0) {

			while (i > j & okOnDelete) {
				jsae = (JSONArray) jsa.getJSONArray(j);
				try {
					jso = (JSONObject) jsae.getJSONObject(0);
					bsrURI = (String) jso.get("value");

					if (!bsrURI.equals(bsrURISSA)) {
						okOnDelete = deleteSpecificRelation(bsrURI, bsrURIAcronimo, "ale63_childOrganizations", baseURL,
								user, password);
						message="deleted relation name ale63_childOrganizations - "+ bsrURIAcronimo+ " from object organization : " +bsrURI ;
					} else
						relation = true;
				} catch (Exception e) {
					e.printStackTrace();
					okOnDelete = false;
				}

				j++;
			}

			result = true;

			if (okOnDelete) {

				if (!relation) {

					result = updateRelationShip(bsrURISSA, "ale63_childOrganizations", bsrURIAcronimo, baseURL, user,
							password);
				}
			} else
				result = false;

		}

		else {
			// ssa & acronimo present without relation particular case
			result = updateRelationShip(bsrURISSA, "ale63_childOrganizations", bsrURIAcronimo, baseURL, user, password);

		}

		if (!result) message=null;


		return message;
	}

	public String getGenericObjectByNameAndVersion(String name, String version, String baseURL, String user,
			String password) {

		// Create the variable to return
		String bsrURI = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%']&p1=bsrURI";

		if (version == null || version.length() == 0)
			version = "00";

		query = query.replaceAll("%CATALOGNAME%", name);
		query = query.replaceAll("%VERSION%", version);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				bsrURI = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (bsrURI != null && bsrURI.equals("[]"))
			bsrURI = null;

		if (bsrURI != null) {
			JSONArray jsa = new JSONArray(bsrURI);
			bsrURI = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
			if (bsrURI != null) {
				bsrURI = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
			}
		}
		return bsrURI;

	}


	public String getGenericObjectByNameAndVersionExtended(String name, String version, String baseURL, String user,
			String password) {

		// Create the variable to return
		String bsrURI = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%']&p1=bsrURI";

		if (version == null || version.length() == 0)
			version = "00";

		query = query.replaceAll("%CATALOGNAME%", name);
		query = query.replaceAll("%VERSION%", version);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				bsrURI = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			bsrURI=">>**ERROR**>>"+e.getMessage();
			e.printStackTrace();

		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (bsrURI != null && !bsrURI.contains(">>**ERROR**>>")) {
			if (bsrURI != null && bsrURI.equals("[]"))
				bsrURI = null;

			if (bsrURI != null) {
				JSONArray jsa = new JSONArray(bsrURI);
				bsrURI = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
				if (bsrURI != null) {
					bsrURI = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
				}
			}
		}
		return bsrURI;

	}


	public String getPropertyValueFromGenericObjectByNameAndVersion(String name, String version, String propertyString,
			String baseURL, String user, String password) {

		// Create the variable to return
		String bsrURI = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%']";

		if (version == null || version.length() == 0)
			version = "00";
		if (propertyString == null || propertyString.length() == 0)
			propertyString = "&p1=bsrURI";

		query = query.replaceAll("%CATALOGNAME%", name);
		query = query.replaceAll("%VERSION%", version);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query).append(propertyString);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				bsrURI = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (bsrURI != null && bsrURI.equals("[]"))
			bsrURI = null;

		return bsrURI;

	}

	public String getPropertyValueFromGenericObjectByName(String name, String propertyString, String baseURL,
			String user, String password) {

		// Create the variable to return
		String bsrURI = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%']";

		if (propertyString == null || propertyString.length() == 0)
			propertyString = "&p1=bsrURI";

		query = query.replaceAll("%CATALOGNAME%", name);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query).append(propertyString);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				bsrURI = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (bsrURI != null && bsrURI.equals("[]"))
			bsrURI = null;

		return bsrURI;

	}

	public String getOrganizationFromGenericObjectByNameAndVersion(String name, String version, String baseURL,
			String user, String password) {

		// Create the variable to return
		String orgName = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%']/ale63_owningOrganization(.)[exactlyClassifiedByAllOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ALEModel%23Organization')]&p1=name";

		query = query.replaceAll("%CATALOGNAME%", name);
		if (version == null || version.length() == 0)
			version = "00";
		query = query.replaceAll("%VERSION%", version);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				orgName = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (orgName != null && orgName.equals("[]"))
			orgName = null;

		if (orgName != null) {
			JSONArray jsa = new JSONArray(orgName);
			orgName = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
			if (orgName != null && orgName != null) {
				orgName = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
			}
		}

		return orgName;

	}


	public String getOrganizationFromGenericObjectByNameAndVersionExtended(String name, String version, String baseURL,
			String user, String password) {

		// Create the variable to return
		String orgName = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%']/ale63_owningOrganization(.)[exactlyClassifiedByAllOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ALEModel%23Organization')]&p1=name";

		query = query.replaceAll("%CATALOGNAME%", name);
		if (version == null || version.length() == 0)
			version = "00";
		query = query.replaceAll("%VERSION%", version);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				orgName = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			orgName=">>**ERROR**>>"+e.getMessage();
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (orgName != null && !orgName.contains(">>**ERROR**>>")) {

			if (orgName != null && orgName.equals("[]"))
				orgName = null;

			if (orgName != null) {
				JSONArray jsa = new JSONArray(orgName);
				orgName = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
				if (orgName != null && orgName != null) {
					orgName = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
				}
			}
		}

		return orgName;

	}


	public String getChildOrganizationFromGenericObjectByName(String name, String baseURL, String user,
			String password) {

		// Create the variable to return
		String orgName = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%']/ale63_childOrganizations(.)[exactlyClassifiedByAllOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ALEModel%23Organization')]&p1=name";

		query = query.replaceAll("%CATALOGNAME%", name);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				orgName = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (orgName != null && orgName.equals("[]"))
			orgName = null;

		if (orgName != null) {
			JSONArray jsa = new JSONArray(orgName);
			orgName = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
			if (orgName != null && orgName != null) {
				orgName = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
			}
		}

		return orgName;

	}

	//
	// get service version associated to the SLA
	//

	public String getConsumersFromSLA(String SLABSRUri, String baseURL, String user, String password) {

		String resultdata = null;

		String classification = "[classifiedByAnyOf(.,'http://isp/%23REG','http://isp/%23SGOPEN','http://isp/%23SAOPEN','http://isp/%23IIBPARAL','http://isp/%23SCIIB','http://isp/%23BSNBP','http://isp/%23MPE','http://isp/%23SAHOST','http://isp/%23RTGEN','http://isp/%23BC')";

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject" + classification
				+ "/gep63_consumes%28.%29[@bsrURI=%27%SLABSRUI%%27]]&p1=bsrURI";

		query = query.replaceAll("%SLABSRUI%", SLABSRUri);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				resultdata = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (resultdata != null && resultdata.equals("[]"))
			resultdata = null;

		if (resultdata != null) {
			JSONArray jsa = new JSONArray(resultdata);
			resultdata = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
			if (resultdata != null && resultdata != null) {
				resultdata = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
			}
		}

		return resultdata;

	}

	public JSONArray getConsumersFromSLAGeneral(String SLABSRUri, String baseURL, String user, String password) {

		JSONArray jsa = null;

		String resultdata=null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[gep63_consumes(.)[@bsrURI='%SLABSRURI%']]&p1=bsrURI&p2=name&p3=primaryType";

		query = query.replaceAll("%SLABSRURI%", SLABSRUri);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				resultdata = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (resultdata != null && !resultdata.equals("[]")) {

			jsa=new JSONArray(resultdata);

		} 
		return jsa;
	}

	//
	// get provider (service Version) from SLD
	//
	//

	public String getProviderFromSLD(String SLADSRUri, String baseURL, String user, String password) {

		String resultdata = null;

		String classification = "[classifiedByAnyOf(.,'http://isp/%23REG','http://isp/%23SGOPEN','http://isp/%23SAOPEN','http://isp/%23IIBPARAL','http://isp/%23SCIIB','http://isp/%23BSNBP','http://isp/%23MPE','http://isp/%23SAHOST','http://isp/%23RTGEN','http://isp/%23BC')";

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject" + classification
				+ "/gep63_provides%28.%29[@bsrURI=%27%SLDBSRUI%%27]]&p1=bsrURI";

		query = query.replaceAll("%SLDBSRUI%", SLADSRUri);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				resultdata = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (resultdata != null && resultdata.equals("[]"))
			resultdata = null;

		if (resultdata != null) {
			JSONArray jsa = new JSONArray(resultdata);
			resultdata = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
			if (resultdata != null && resultdata != null) {
				resultdata = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
			}
		}

		return resultdata;

	}

	//
	// get classification type from service -version
	//
	//

	public String getServiceVersionClassification(String BSRUriServiceVersion, String baseURL, String user,
			String password) {

		String resultdata = null;

		String query = "/Metadata/JSON/%BSRURI%/classifications";

		query = query.replaceAll("%BSRURI%", BSRUriServiceVersion);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				resultdata = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (resultdata != null) {

			if (resultdata.contains("#REG"))
				resultdata = "REG";
			if (resultdata.contains("#SGOPEN"))
				resultdata = "SGOPEN";
			if (resultdata.contains("#SAOPEN"))
				resultdata = "SAOPEN";
			if (resultdata.contains("#IIBPARAL"))
				resultdata = "IIBPARAL";
			if (resultdata.contains("#SCIIB"))
				resultdata = "SCIIB";
			if (resultdata.contains("#BSNBP"))
				resultdata = "BSNBP";
			if (resultdata.contains("#MPE"))
				resultdata = "MPE";
			if (resultdata.contains("#SAHOST"))
				resultdata = "SAHOST";
			if (resultdata.contains("#RTGEN"))
				resultdata = "RTGEN";
			if (resultdata.contains("#BC"))
				resultdata = "BC";
			//211216
			if (resultdata.contains("#SOM"))
				resultdata = "SOM";
			if (resultdata.contains("#EP"))
				resultdata = "EP";
			if (resultdata.contains("#AGGR"))
				resultdata = "AGGR";
			//110117
			if (resultdata.contains("#SHLIB"))
				resultdata = "SHLIB";
			if (resultdata.contains("#FNZCD"))
				resultdata = "FNZCD";
		}

		return resultdata;

	}

	public String checkClassification(String bsrURI, String classification,String baseURL, String user,
			String password) {

		String resultdata = null;

		String result=null;

		String query = "/Metadata/JSON/%BSRURI%/classifications";

		query = query.replaceAll("%BSRURI%", bsrURI);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				resultdata = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			resultdata=">>**ERROR**>>"+e.getMessage();
			e.printStackTrace();

		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (resultdata != null && !resultdata.contains(">>**ERROR**>>")) {


			if (resultdata.contains(classification)) {

				result=classification;
			}


		}

		return result;

	}


	//
	// get SSA from SLA
	//
	// steps: get SLD from SSA ,get provider from SLD , get Acronimo from
	// provider, get SSA from acronimo
	//

	public String getSSAFromSLA(String SLABSRUri, String baseURL, String user, String password) {

		String result = getSLDFromSLA(SLABSRUri, baseURL, user, password); // get
		// SLD

		result = getProviderFromSLD(result, baseURL, user, password); // get
		// Privider

		result = getOwningOrganizationFromGenericObjectByBsrUri(result, baseURL, user, password); // get
		// acronimo

		result = getSSAFromAcronimo(result, baseURL, user, password); // gest
		// SSA

		return result;

	}

	//
	// get SLD associated to SLA
	//

	public String getSLDFromSLA(String SLABSRUri, String baseURL, String user, String password) {

		String resultdata = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@bsrURI='%SLABSRURI%']/gep63_agreedEndpoints%28.%29[exactlyClassifiedByAllOf%28.,%27http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel%23ServiceLevelDefinition%27%29]&p1=bsrURI";

		query = query.replaceAll("%SLABSRURI%", SLABSRUri);

		// System.out.println(query);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				resultdata = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (resultdata != null && resultdata.equals("[]"))
			resultdata = null;

		if (resultdata != null) {
			JSONArray jsa = new JSONArray(resultdata);
			resultdata = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
			if (resultdata != null && resultdata != null) {
				resultdata = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
			}
		}

		return resultdata;

	}

	//
	// get SSA from Acronimo
	//

	public String getSSAFromAcronimo(String bsrURIAcronimo, String baseURL, String user, String password) {

		String resultdata = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[classifiedByAnyOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ALEModel%23Organization')/ale63_childOrganizations(.)[@name='%BSRURIACRONIMO%']]&p1=name";
		query = query.replaceAll("%BSRURIACRONIMO%", bsrURIAcronimo);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				resultdata = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (resultdata != null && resultdata.equals("[]"))
			resultdata = null;

		if (resultdata != null) {
			JSONArray jsa = new JSONArray(resultdata);
			resultdata = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
			if (resultdata != null) {
				resultdata = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
			}
		}
		return resultdata;
	}

	//
	// get all object of type specified by Primary Type
	//

	public JSONArray getAllObjectsSpecifiedByPrimaryType(String primaryType, String baseURL, String user,
			String password) {

		String resultdata = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@primaryType='%PRIMARYTYPE%']&p1=bsrURI";

		query = query.replaceAll("%PRIMARYTYPE%", primaryType);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				resultdata = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		JSONArray jsa = new JSONArray(resultdata);

		return jsa;

	}

	//
	// Check is a object is of particular primarytype if so return jsonArray with selected properties
	//

	public JSONArray getObjectPropertiesData(String bsrURI, String queryString,String baseURL, String user,
			String password) {

		String properties=null;
		JSONArray jsa=null;

		//&p1=name

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@bsrURI='%BSRURI%']"+queryString;

		query = query.replaceAll("%BSRURI%", bsrURI);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				properties = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (properties != null) {

			jsa=new JSONArray(properties);

		} 
		return jsa;

	}


	//
	// Check is a object is of particular primarytype and name if so return jsonArray with selected properties
	//

	public JSONArray getPropertiesByObjectNameAndPrimaryType(String name, String primaryType, String queryString,String baseURL, String user,
			String password) {

		String properties=null;
		JSONArray jsa=null;

		//&p1=name

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%NAME%'%20and%20@primaryType='%PRIMARYTYPE%']"+queryString;

		query = query.replaceAll("%NAME%", name);
		query = query.replaceAll("%PRIMARYTYPE%", primaryType);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				properties = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (properties != null) {

			jsa=new JSONArray(properties);

		} 
		return jsa;

	}

	public JSONArray getPropertiesByURI(String bsrURI, String queryString,String baseURL, String user,
			String password) {

		String properties=null;
		JSONArray jsa=null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@bsrURI='%BSRURI%']"+queryString;

		query = query.replaceAll("%BSRURI%", bsrURI);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				properties = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (properties != null) {

			jsa=new JSONArray(properties);

		} 
		return jsa;

	}

	public String getOwningOrganizationFromGenericObjectByBsrUri(String bsrURI, String baseURL, String user,
			String password) {

		// Create the variable to return
		String orgName = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@bsrURI='%BSRURI%']/ale63_owningOrganization(.)[exactlyClassifiedByAllOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ALEModel%23Organization')]&p1=name";

		query = query.replaceAll("%BSRURI%", bsrURI);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				orgName = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (orgName != null && orgName.equals("[]"))
			orgName = null;

		if (orgName != null) {
			JSONArray jsa = new JSONArray(orgName);
			orgName = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
			if (orgName != null && orgName != null) {
				orgName = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
			}
		}

		return orgName;

	}

	public String getGenericObjectByNameAndPrimaryType(String name, String primaryType, String baseURL, String user,
			String password) {

		// Create the variable to return
		String bsrURI = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@primaryType='%PRIMARYTYPE%']&p1=bsrURI";

		query = query.replaceAll("%CATALOGNAME%", name);
		query = query.replaceAll("%PRIMARYTYPE%", primaryType);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				bsrURI = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (bsrURI != null && bsrURI.equals("[]"))
			bsrURI = null;

		if (bsrURI != null) {
			JSONArray jsa = new JSONArray(bsrURI);
			bsrURI = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
			if (bsrURI != null) {
				bsrURI = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
			}
		}
		return bsrURI;

	}


	public String getGenericObjectByNameAndPrimaryTypeExtended(String name, String primaryType, String baseURL, String user,
			String password) {

		// Create the variable to return
		String bsrURI = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@primaryType='%PRIMARYTYPE%']&p1=bsrURI";
		//String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[matches(@name,'%CATALOGNAME%')%20and%20@primaryType='%PRIMARYTYPE%']&p1=bsrURI";

		query = query.replaceAll("%CATALOGNAME%", name);
		query = query.replaceAll("%PRIMARYTYPE%", primaryType);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				bsrURI = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			bsrURI=">>**ERROR**>>"+e.getMessage();
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (bsrURI != null && !bsrURI.contains(">>**ERROR**>>")) {

			if (bsrURI != null && bsrURI.equals("[]"))
				bsrURI = null;

			if (bsrURI != null) { //first element
				JSONArray jsa = new JSONArray(bsrURI);
				bsrURI = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
				if (bsrURI != null) {
					bsrURI = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
				}
			}
		}
		return bsrURI;

	}

	public String getEndpointInfo(String name, String version, String interfaceType, String environment, String baseURL,
			String user, String password) {

		// Create the variable to return
		String data = null;
		String query = null;
		String environmentQuery = "http://www.ibm.com/xmlns/prod/serviceregistry/6/1/GovernanceProfileTaxonomy%23%ENVIRONMENT%";
		environmentQuery = environmentQuery.replace("%ENVIRONMENT%", environment);

		if (version == null || version.length() == 0)
			version = "00";

		String querySOAP = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%']/gep63_provides(.)/gep63_availableEndpoints(.)[exactlyClassifiedByAllOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ServiceModel%23SOAPServiceEndpoint')%20and%20exactlyClassifiedByAllOf(.,'%ENVIRONMENT%')]&p1=bsrURI&p2=sm63_DATA_PRIMO_UTILIZZO";
		String queryREST = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%']/gep63_provides(.)/gep63_availableEndpoints(.)[exactlyClassifiedByAllOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/profile/v8r0/RESTModel%23RESTServiceEndpoint')%20and%20exactlyClassifiedByAllOf(.,'%ENVIRONMENT%')]&p1=bsrURI&p2=sm63_DATA_PRIMO_UTILIZZO";

		String queryCICS = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%']/gep63_provides(.)/gep63_availableEndpoints(.)[exactlyClassifiedByAllOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ServiceModel%23CICSServiceEndpoint')%20and%20exactlyClassifiedByAllOf(.,'%ENVIRONMENT%')]&p1=bsrURI&p2=sm63_DATA_PRIMO_UTILIZZO";
		String queryMQ = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%']/gep63_provides(.)/gep63_availableEndpoints(.)[exactlyClassifiedByAllOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ServiceModel%23MQServiceEndpoint')%20and%20exactlyClassifiedByAllOf(.,'%ENVIRONMENT%')]&p1=bsrURI&p2=sm63_DATA_PRIMO_UTILIZZO";
		//110117
		String queryCALLABLE = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%']/gep63_provides(.)/gep63_availableEndpoints(.)[exactlyClassifiedByAllOf(.,'http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ServiceModel%23CALLABLEServiceEndpoint')%20and%20exactlyClassifiedByAllOf(.,'%ENVIRONMENT%')]&p1=bsrURI&p2=sm63_DATA_PRIMO_UTILIZZO";
		
		if (interfaceType.equals("REST")) query=queryREST;
		if (interfaceType.equals("SOAP")) query=querySOAP;
		if (interfaceType.equals("CICS")) query=queryCICS;
		if (interfaceType.equals("MQ")) query=queryMQ;
		//110117
		if (interfaceType.equals("CALLABLE")) query=queryCALLABLE;


		query = query.replaceAll("%CATALOGNAME%", name);
		query = query.replaceAll("%VERSION%", version);
		query = query.replaceAll("%ENVIRONMENT%", environmentQuery);


		HttpURLConnection urlConnection = null;

		//System.out.println(query);

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {

				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				data = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}

				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		// [{"value":"bc8f48bc-d1ab-4b30.9543.876ea38743a1","name":"bsrURI"},{"value":null,"name":"gep63_DATA_PRIMO_UTILIZZO"}]]

		if (data != null && data.equals("[]"))
			data = null;

		return data;

	}


	//utilizzata nella funzione caricamento SLA 

	//bsrUri interfaccia MQ padre

	public String getManualMQEndpointInfo(String bsrURI,  String baseURL,
			String user, String password) {

		// Create the variable to return
		String data = null;
		String query = null;

		query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@bsrURI='%BSRURI%']/sm63_mqEndpoint(.)&p1=bsrURI&p2=sm63_DATA_PRIMO_UTILIZZO_MQM&p3=sm63_DATA_ULTIMO_UTILIZZO_MQM";

		query = query.replaceAll("%BSRURI%", bsrURI);

		HttpURLConnection urlConnection = null;


		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {

				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				data = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}

				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (data != null && data.equals("[]"))
			data = null;

		return data;

	}


	//13.08.2016
	//utilizzo la query nel totalizzatore quando lavoro con associazioni bv e av
	public JSONArray getEndpointInfoFromBsrUriCatalogAndEnvironment(String bsrURI,String environment, String baseURL,
			String user, String password) {

		// Create the variable to return
		JSONArray data = null;
		String query = null;

		String environmentQuery = "http://www.ibm.com/xmlns/prod/serviceregistry/6/1/GovernanceProfileTaxonomy%23%ENVIRONMENT%";
		environmentQuery = environmentQuery.replaceAll("%ENVIRONMENT%", environment);

		query= "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@bsrURI='%BSRURI%']/gep63_provides(.)/gep63_availableEndpoints(.)[exactlyClassifiedByAllOf(.,'%ENVIRONMENT%')]&p1=bsrURI&p2=sm63_DATA_PRIMO_UTILIZZO&p3=sm63_DATA_ULTIMO_UTILIZZO&p4=sm63_endpointType";
		query = query.replaceAll("%BSRURI%", bsrURI);
		query = query.replaceAll("%ENVIRONMENT%", environmentQuery);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				data = new JSONArray(sb.toString());
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (data != null && data.equals("[]"))
			data = null;

		return data;

	}

	public JSONArray getEndpointInfoFromInterface(String bsrURI,String environment, String baseURL,
			String user, String password) {

		// Create the variable to return
		JSONArray data = null;
		String query = null;

		String environmentQuery = "http://www.ibm.com/xmlns/prod/serviceregistry/6/1/GovernanceProfileTaxonomy%23%ENVIRONMENT%";
		environmentQuery = environmentQuery.replaceAll("%ENVIRONMENT%", environment);

		query= "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@bsrURI='%BSRURI%']/gep63_availableEndpoints(.)[exactlyClassifiedByAllOf(.,'%ENVIRONMENT%')]&p1=bsrURI&p2=sm63_DATA_PRIMO_UTILIZZO&p3=sm63_DATA_ULTIMO_UTILIZZO";
		query = query.replaceAll("%BSRURI%", bsrURI);
		query = query.replaceAll("%ENVIRONMENT%", environmentQuery);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				data = new JSONArray(sb.toString());
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (data != null && data.equals("[]"))
			data = null;

		return data;

	}

	public JSONArray getAssociatedInterfaces(String name, String version, String baseURL,
			String user, String password) {

		// Create the variable to return

		JSONArray data = null;
		String query = null;

		if (version == null || version.length() == 0)
			version = "00";

		//String query="/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name=%CATALOGNAME%27%20and%20@version=%27VERSION%27]/gep63_provides%28.%29/gep63_availableEndpoints%28.%29&p1=bsrURI&p2=name";

		query="/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%'%20and%20@version='%VERSION%']/gep63_provides%28.%29/gep63_serviceInterface%28.%29&p1=bsrURI&p2=name";

		query = query.replace("%CATALOGNAME%", name);
		query = query.replace("%VERSION%", version);

		// tipo interfaccia non supportato

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				data = new JSONArray(sb.toString());
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}

				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		// [{"value":"bc8f48bc-d1ab-4b30.9543.876ea38743a1","name":"bsrURI"},{"value":null,"name":"gep63_DATA_PRIMO_UTILIZZO"}]]

		if (data != null && data.equals("[]"))
			data = null;

		return data;

	}



	public String getGenericObjectByName(String name, String baseURL, String user, String password) {

		// Create the variable to return
		String bsrURI = null;

		String query = "/Metadata/JSON/PropertyQuery?query=/WSRR/GenericObject[@name='%CATALOGNAME%']&p1=bsrURI";

		query = query.replaceAll("%CATALOGNAME%", name);

		HttpURLConnection urlConnection = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(baseURL).append(query);
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);
			}

			int responsecode = urlConnection.getResponseCode();
			if (responsecode == 200 || (responsecode == 201)) {
				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				bsrURI = sb.toString();
				is.close();
			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (bsrURI != null && bsrURI.equals("[]"))
			bsrURI = null;

		if (bsrURI != null) {
			JSONArray jsa = new JSONArray(bsrURI);
			bsrURI = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
			if (bsrURI != null) {
				bsrURI = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
			}
		}
		return bsrURI;

	}

	public String createWSRRGenericObject(String xmlData, String verb, String createURL, String user, String password) {

		// Create the variable to return
		String bsrURI = null;
		HttpURLConnection urlConnection = null;
		StringBuffer sb = new StringBuffer();
		sb.append(createURL).append("/Content/GenericObject");
		try {
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod(verb);
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);

			}

			byte[] postDataBytes = xmlData.getBytes("UTF-8");
			urlConnection.getOutputStream().write(postDataBytes);

			int returnCode = urlConnection.getResponseCode();

			if (returnCode == 200 || (returnCode == 201)) {

				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				bsrURI = sb.toString();
				is.close();

			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
				throw new Exception("Unable to create WSRR GenericObject " + stringBuffer.toString());
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		if (bsrURI !=null) bsrURI = WSRRUtility.getbsrURI(bsrURI);

		return bsrURI;
	}

	public boolean updateSinglePropertyXMLFormat(String bsrURIToChange, String propertyName, String propertyValue,
			String createURL, String user, String password) {

		// Create the variable to return
		boolean result = false;
		String query = "/Metadata/XML/%BSRURI%/properties/%PROPERTYNAME%";
		String value = "<property value=\"%VALUE%\"/> ";
		if (bsrURIToChange == null || bsrURIToChange.length() == 0)
			bsrURIToChange = "bsrURI_not_Specified";
		if (propertyName == null || propertyName.length() == 0)
			propertyName = "propertyName_not_Specified";

		query = query.replaceAll("%BSRURI%", bsrURIToChange);
		query = query.replaceAll("%PROPERTYNAME%", propertyName);
		value = value.replaceAll("%VALUE%", propertyValue);

		HttpURLConnection urlConnection = null;
		StringBuffer sb = new StringBuffer();
		sb.append(createURL).append(query);
		try {
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("PUT");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);

			}

			byte[] postDataBytes = value.getBytes("UTF-8");
			urlConnection.getOutputStream().write(postDataBytes);

			int returnCode = urlConnection.getResponseCode();

			if (returnCode == 200 || (returnCode == 201)) {

				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				result = true;
				is.close();

			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
				throw new Exception("Unable to create WSRR GenericObject " + stringBuffer.toString());
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		return result;
	}

	public boolean updateRelationShip(String bsrURIToChange, String relationName, String bsrURITarget, String createURL,
			String user, String password) {

		// Create the variable to return
		boolean result = false;
		/// Metadata/JSON/<bsrURI>/properties/Metadata/JSON/<bsrURI>/relationships
		// String
		/// value="[{\"delete\":\"false\",\"relationships\":[{\"name\":\"%RELATIONNAME%\",\"targetBsrURI\":\"%TARGETBSRURI%\"}]}]";
		String query = "/Metadata/XML/%BSRURI%/relationships";

		String value = "<relationships delete=\"false\"><relationship name=\"%RELATIONNAME%\" targetBsrURI=\"%TARGETBSRURI%\"/></relationships>";

		if (bsrURIToChange == null || bsrURIToChange.length() == 0)
			bsrURIToChange = "bsrURI_not_Specified";
		if (relationName == null || relationName.length() == 0)
			relationName = "relationName_not_Specified";
		if (bsrURITarget == null || bsrURITarget.length() == 0)
			bsrURITarget = "bsrUriTarget_not_Specified";

		query = query.replaceAll("%BSRURI%", bsrURIToChange);
		value = value.replaceAll("%RELATIONNAME%", relationName);
		value = value.replaceAll("%TARGETBSRURI%", bsrURITarget);

		HttpURLConnection urlConnection = null;
		StringBuffer sb = new StringBuffer();
		sb.append(createURL).append(query);
		try {
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("PUT");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);

			}

			byte[] postDataBytes = value.getBytes("UTF-8");
			urlConnection.getOutputStream().write(postDataBytes);

			int returnCode = urlConnection.getResponseCode();

			if (returnCode == 200 || (returnCode == 201)) {

				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				result = true;
				is.close();

			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
				throw new Exception("Unable to create WSRR GenericObject " + stringBuffer.toString());
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		return result;
	}

	public boolean updateSinglePropertyJSONFormat(String bsrURIToChange, String propertyName, String propertyValue,
			String createURL, String user, String password) {

		// Create the variable to return
		boolean result = false;
		String query = "/Metadata/JSON/%BSRURI%/properties/%PROPERTYNAME%";
		String value = "{\"value\":\"%VALUE%\"}";
		if (bsrURIToChange == null || bsrURIToChange.length() == 0)
			bsrURIToChange = "bsrURI_not_Specified";
		if (propertyName == null || propertyName.length() == 0)
			propertyName = "propertyName_not_Specified";

		query = query.replaceAll("%BSRURI%", bsrURIToChange);
		query = query.replaceAll("%PROPERTYNAME%", propertyName);
		value = value.replaceAll("%VALUE%", propertyValue);

		HttpURLConnection urlConnection = null;
		StringBuffer sb = new StringBuffer();
		sb.append(createURL).append(query);
		try {
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("PUT");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);

			}

			byte[] postDataBytes = value.getBytes("UTF-8");
			urlConnection.getOutputStream().write(postDataBytes);

			int returnCode = urlConnection.getResponseCode();

			if (returnCode == 200 || (returnCode == 201)) {

				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				result = true;
				is.close();

			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
				throw new Exception("Unable to create WSRR GenericObject " + stringBuffer.toString());
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		return result;
	}

	public boolean changeGovernanceState(String bsrUri, String[] transations, String createURL, String user,
			String password) {

		boolean result = false;
		;

		HttpURLConnection urlConnection = null;
		StringBuffer sb = new StringBuffer();

		for (String action : transations) {
			result = false;
			sb.delete(0, sb.length());
			sb.append(createURL).append("/Metadata/XML/").append(bsrUri).append("/governance/").append(action);

			try {
				URL url = new URL(sb.toString());
				urlConnection = (HttpURLConnection) url.openConnection();
				urlConnection.setRequestMethod("PUT");
				urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
				urlConnection.setDoInput(true);
				urlConnection.setDoOutput(true);
				urlConnection.setUseCaches(false);

				if (user != null && password != null) {

					String userPassword = user + ":" + password;

					String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

					urlConnection.setRequestProperty("Authorization", "Basic " + encoding);

				}

				int returnCode = urlConnection.getResponseCode();

				if (returnCode == 200 || (returnCode == 201)) {

					InputStream is = null;
					is = urlConnection.getInputStream();
					int ch;
					sb.delete(0, sb.length());
					while ((ch = is.read()) != -1) {
						sb.append((char) ch);
					}
					result = true;

				} else {
					BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
					StringBuffer stringBuffer = new StringBuffer();
					String line = null;
					while (null != (line = reader.readLine())) {
						stringBuffer.append(line);
					}
					reader.close();
				}
				urlConnection.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				if (urlConnection != null)
					urlConnection.disconnect();
			}

			if (!result)
				break;

		}

		return result;
	}

	public boolean deleteWSRRObject(String bsrURI, String createURL, String user, String password) {

		boolean result = false;

		// Create the variable to return
		HttpURLConnection urlConnection = null;
		StringBuffer sb = new StringBuffer();
		sb.append(createURL).append("/Content/").append(bsrURI);
		try {
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("DELETE");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);

			}

			int returnCode = urlConnection.getResponseCode();

			if (returnCode == 200 || (returnCode == 201)) {

				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				result = true;
				is.close();

			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
				throw new Exception("Unable to delete WSRR GenericObject " + stringBuffer.toString());
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		return result;

	}

	public boolean deleteSpecificRelation(String bsrURIBaseObject, String bsrURSpecific, String relationName,
			String createURL, String user, String password) {

		boolean result = false;

		String query = "/Metadata/XML/%BASEOBJECT%/relationships/%RELATIONNAME%/%TARTGETOBJECT%";
		query = query.replaceAll("%BASEOBJECT%", bsrURIBaseObject);
		query = query.replaceAll("%RELATIONNAME%", relationName);
		query = query.replaceAll("%TARTGETOBJECT%", bsrURSpecific);

		// Create the variable to return
		HttpURLConnection urlConnection = null;
		StringBuffer sb = new StringBuffer();
		sb.append(createURL).append(query);
		try {
			URL url = new URL(sb.toString());
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("DELETE");
			urlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			urlConnection.setUseCaches(false);

			if (user != null && password != null) {

				String userPassword = user + ":" + password;

				String encoding = new String(Base64.encodeBase64(userPassword.getBytes()));

				urlConnection.setRequestProperty("Authorization", "Basic " + encoding);

			}

			int returnCode = urlConnection.getResponseCode();

			if (returnCode == 200 || (returnCode == 201)) {

				InputStream is = null;
				is = urlConnection.getInputStream();
				int ch;
				sb.delete(0, sb.length());
				while ((ch = is.read()) != -1) {
					sb.append((char) ch);
				}
				result = true;
				is.close();

			} else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while (null != (line = reader.readLine())) {
					stringBuffer.append(line);
				}
				reader.close();
				throw new Exception("Unable to delete WSRR GenericObject " + stringBuffer.toString());
			}
			urlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		return result;

	}

	public static String extractPropertyValue(String data) {
		String result = null;

		try {
			JSONArray jsa = new JSONArray(data);
			result = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("name");
			if (result != null) {
				result = ((JSONObject) ((JSONArray) jsa.get(0)).get(0)).getString("value");
			}
		} catch (Exception ex) {
			// nothing
		}

		return result;

	}

	private static String getbsrURI(String response) {

		String bsrURI = "";

		if (response != null && response.contains("bsrURI")) {
			int pos = response.indexOf("name=\"bsrURI\" value=\"");// 21
			bsrURI = response.substring(pos + 21, pos + 21 + 36);
		}

		return bsrURI;

	}

	public static String unescape(String string) {
		StringBuffer res=new StringBuffer();
		for (int i=0;i<string.length();i++) {
			Character ch = new Character(string.charAt(i));
			res.append(ch);
		}
		return res.toString();

	}
}
