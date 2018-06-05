package com.isp.wsrr.envelopes;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ibm.serviceregistry.sdo.helper.PropertyConstants;

import teamworks.TWList;


//24/10/2016 ambito e ambito-descr
//25/10/2016 pubblicatore e data
//09/12/2016 PROPERTY_GPX63_USERDEFTIME inserito nuovo campo nella creazione SLA
//15032017 aggiunti campi alla AV per aderire al modello
//03/02/2018 aggiunti gep63_SOPEN_ABILITAZ_READ - gep63_SOPEN_ABILITAZ_WRITE - gep63_SOPEN_MOD_UTENTI_BUS
//28/02/2018 aggiunto gep63_SCHOST_ACRONIMO_RTC
//05/06/2018 aggiunti i tre campi: gep63_CAT_SERVIZIO - gep63_CAT_INPUT - gep63_CAT_OUTPUT
public class WSRREnvelopes {

	public WSRREnvelopes() {
	}

	// XML Processing Constants
	DocumentBuilderFactory docBuilderFactory = null;
	DocumentBuilder docBuilder = null;

	private XPathExpression valueAttrExpression = null;
	private static final String XPATH_EXPR_VALUE_ATTR = "//property/@value";

	// REST XML Element Name Constants
	private static final String ELEMENT_RESOURCES = "resources";
	private static final String ELEMENT_RESOURCE = "resource";
	private static final String ELEMENT_PROPERTIES = "properties";
	private static final String ELEMENT_PROPERTY = "property";
	private static final String ELEMENT_RELATIONSHIPS = "relationships";
	private static final String ELEMENT_RELATIONSHIP = "relationship";
	private static final String ELEMENT_CLASSIFICATIONS = "classifications";
	private static final String ELEMENT_CLASSIFICATION = "classification";

	// REST XML Attribute Name Constants
	private static final String ATTR_NAME = "name";
	private static final String ATTR_VALUE = "value";
	private static final String ATTR_TARGET_BSRURI = "targetBsrURI";
	private static final String ATTR_TARGET_TYPE = "targetType";
	private static final String ATTR_URI = "uri";
	private static final String ATTR_PRIMARY_TYPE = "primaryType";

	// WSRR Property Name Constants
	private static final String PROPERTY_ALE63_ASSET_WEB_LINK = "ale63_assetWebLink";
	private static final String PROPERTY_ALE63_FULL_DESCRIPTION = "ale63_fullDescription";
	private static final String PROPERTY_ALE63_REMOTE_STATE = "ale63_remoteState";
	private static final String PROPERTY_ALE63_ASSET_TYPE = "ale63_assetType";
	private static final String PROPERTY_ALE63_REQUIREMENTS_LINK = "ale63_requirementsLink";
	private static final String PROPERTY_ALE63_OWNER_EMAIL = "ale63_ownerEmail";
	private static final String PROPERTY_ALE63_GUID = "ale63_guid";
	private static final String PROPERTY_ALE63_COMMUNITY_NAME = "ale63_communityName";
	private static final String PROPERTY_ALE63_ASSET_OWNERS = "ale63_assetOwners";
	private static final String PROPERTY_GEP63_CONSUMER_IDENTIFIER = "gep63_consumerIdentifier";
	private static final String PROPERTY_GEP63_VERSION_AVAILABILITY_DATE = "gep63_versionAvailabilityDate";
	private static final String PROPERTY_GEP63_VERSION_TERMINATION_DATE = "gep63_versionTerminationDate";
	private static final String PROPERTY_GEP63_CONSUMER_IDENTIFIER_LOCATION = "gep63_consumerIdentifierLocationInfo";
	private static final String PROPERTY_GEP63_CONTEXT_IDENTIFIER_LOCATION = "gep63_contextIdentifierLocationInfo";

	// SLA
	private static final String PROPERTY_GPX63_PEAK_MESSAGE_RETAIL_DURATION = "gpx63_peakMessageRateDailyDuration";
	private static final String PROPERTY_GPX63_PEAK_MESSAGE_RETAIL_TIME = "gpx63_peakMessageRateDailyTime";
	private static final String PROPERTY_GEP63_VERSION_MATCH_CRITERIA = "gep63_versionMatchCriteria";
	private static final String PROPERTY_GEP63_CONTEXT_IDENTIFIER = "gep63_contextIdentifier";
	private static final String PROPERTY_GPX63_MAXIMUM_MESSAGE_PERDAY = "gpx63_maximumMessagesPerDay";
	private static final String PROPERTY_GPX63_AVERAGE_MESSAGE_PERDAY = "gpx63_averageMessagesPerDay";
	private static final String PROPERTY_GPX63_PEAK_MESSAGE_RATE = "gpx63_peakMessageRate";
	private static final String PROPERTY_GPX63_MINIMUM_MESSAGE_PERDAY = "gpx63_minimumMessagesPerDay";
	private static final String PROPERTY_GEP63_SUBSCRIPTION_TERMINATE_DATE = "gep63_subscriptionTerminationDate";
	private static final String PROPERTY_GEP63_SUBSCRIPTION_AVALILABILITY_DATE = "gep63_subscriptionAvailabilityDate";
	//custom
	private static final String PROPERTY_GPX63_RUNTIME = "gpx63_RUNTIME";
	private static final String PROPERTY_GPX63_DESIGNTIME = "gpx63_DESIGNTIME";
	//inserito il 09122016
	private static final String PROPERTY_GPX63_USERDEFTIME = "gpx63_USERDEFTIME";

	private static final String PROPERTY_ALE63_CONTACT = "ale63_contact";
	private static final String PROPERTY_ALE63_CONTACT_EMAIL = "ale63_contactEmail";

	// WSRR Relationship Name Constants
	private static final String RELATIONSHIP_ALE63_DEPENDENCY = "ale63_dependency";
	private static final String RELATIONSHIP_ALE63_ARTIFACTS = "ale63_artifacts";
	private static final String RELATIONSHIP_ALE63_OWNING_ORGANIZATION = "ale63_owningOrganization";
	private static final String RELATIONSHIP_GEP63_SERVICE_INTERFACE_VERSIONS = "gep63_serviceInterfaceVersions";
	private static final String RELATIONSHIP_GEP63_CHARTER = "gep63_charter";
	private static final String RELATIONSHIP_GEP63_CAPABILITY_VERSIONS = "gep63_capabilityVersions";
	private static final String RELATIONSHIP_GEP63_CONSUMES = "gep63_consumes";
	private static final String RELATIONSHIP_GEP63_PROVIDES = "gep63_provides";
	private static final String RELATIONSHIP_GEP63_INTERFACE_SPECIFICATIONS = "gep63_interfaceSpecifications";
	private static final String RELATIONSHIP_GEP63_PROVIDED_WEB_SERVICES = "gep63_providedWebServices";
	private static final String RELATIONSHIP_GEP63_PROVIDED_REST_SERVICES = "gep63_providedRESTServices";
	private static final String RELATIONSHIP_GEP63_PROVIDED_SCA_MODULES = "gep63_providedSCAModules";
	private static final String RELATIONSHIP_GEP63_BOUND_SCA_EXPORT = "gep63_boundScaExport";
	private static final String RELATIONSHIP_GEP63_ANONYMOUS_SLA = "gep63_anonymousSLA";
	private static final String RELATIONSHIP_GEP63_CAMPATIBLE_SLDS = "gep63_compatibleSLDs";
	private static final String RELATIONSHIP_GEP63_BOUND_WEB_SERVICE_PORT = "gep63_boundWebServicePort";
	private static final String RELATIONSHIP_GEP63_BOUND_REST_SERVICE = "gep63_boundRESTService";
	private static final String RELATIONSHIP_GEP63_AVAILABLE_OPERATIONS = "gep63_availableOperations";

	// SLA
	private static final String RELATIONSHIP_GEP63_BOUND_SCA_IMPORT = "gep63_boundSCAimport";
	private static final String RELATIONSHIP_GEP63_AGREED_ENDPOINTS = "gep63_agreedEndpoints";
	private static final String RELATIONSHIP_GEP63_SERVICE_LEVEL_POLICIES = "gep63_serviceLevelPolicies";

	private static final String RELATIONSHIP_GEP63_CHILD_ORGANIZATIONS = "ale63_childOrganizations";

	// WSRR OWL URI Constants
	private static final String OWL_ORGANIZATION = "http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ALEModel#Organization";
	private static final String OWL_BUSINESS_APPLICATION = "http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel#BusinessApplication";
	private static final String OWL_BUSINESS_APPLICATION_VERSION = "http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel#ApplicationVersion";
	private static final String OWL_SERVICE_LEVEL_AGREEMENT = "http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceProfileExtensions#ServiceLevelAgreement";

	private static final String OWL_URI_SLD = "http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel#ServiceLevelDefinition";
	private static final String OWL_REST_INTERFACE = "http://www.ibm.com/xmlns/prod/serviceregistry/profile/v8r0/RESTModel#RESTServiceInterface";

	private static final String OWL_REST_ENDPOINT = "http://www.ibm.com/xmlns/prod/serviceregistry/profile/v8r0/RESTModel#RESTServiceEndpoint";
	private static final String OWL_SOAP_ENDPOINT = "http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ServiceModel#SOAPServiceEndpoint";
	private static final String OWL_CICS_ENDPOINT = "http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ServiceModel#CICSServiceEndpoint";
	private static final String OWL_MQ_ENDPOINT = "http://www.ibm.com/xmlns/prod/serviceregistry/v6r3/ServiceModel#MQServiceEndpoint";

	private static final String OWL_ENVIRONMENT_STATE = "http://www.ibm.com/xmlns/prod/serviceregistry/6/1/GovernanceProfileTaxonomy#";

	// ISP Object Definition - Business Service Extensions
	private static final String OWL_URI_ISP_SERVICE = "http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel#";

	// ISP Object Definition - Business Service Version Extensions
	private static final String OWL_URI_ISP_SERVICE_VERSION = "http://www.ibm.com/xmlns/prod/serviceregistry/profile/v6r3/GovernanceEnablementModel#";
	// Misc. String Constants

	private static final String ISP_ACRONIMO_CLASSIFICATION="http://isp/#Acronimo";
			
	private static final String ISP_SSA_CLASSIFICATION="http://isp/#SSA";
	
	private static final String EMPTY_STRING = "";

	public String createBusinessApplicationXMLData(String name, String description, String bsrUriapplicationVersion,
			String bsrUriOrganization) {

		String output = null;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}

			Document document = docBuilder.newDocument();

			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAME, name));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAMESPACE, ""));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.VERSION, ""));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.DESCRIPTION, description));

			propertiesElement.appendChild(
					createPropertyElement(document, PropertyConstants.PRIMARY_TYPE, OWL_BUSINESS_APPLICATION));

			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_REMOTE_STATE, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_COMMUNITY_NAME, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_COMMUNITY_NAME, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_OWNERS, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_TYPE, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_GUID, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_ALE63_FULL_DESCRIPTION, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_OWNER_EMAIL, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_WEB_LINK, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_ALE63_REQUIREMENTS_LINK, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_TYPE, EMPTY_STRING));

			// Relationships element
			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);

			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_CHARTER, null));
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_ALE63_ARTIFACTS, null));
			String targetUri = (bsrUriapplicationVersion == null) ? null : bsrUriapplicationVersion;
			relationshipsElement.appendChild(
					createRelationshipElement(document, RELATIONSHIP_GEP63_CAPABILITY_VERSIONS, targetUri));
			targetUri = (bsrUriOrganization == null) ? null : bsrUriOrganization;
			relationshipsElement.appendChild(
					createRelationshipElement(document, RELATIONSHIP_ALE63_OWNING_ORGANIZATION, targetUri));
			relationshipsElement.appendChild(
					createRelationshipElement(document, RELATIONSHIP_GEP63_SERVICE_INTERFACE_VERSIONS, null));
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_ALE63_DEPENDENCY, null));

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");

		} catch (Exception e) {
			e.printStackTrace();
			output = null;
		}

		return output;
	}

	public String createServiceLevelAgreementXMLDAta(String name, String description, String attivato_appl ,String attivato_syst,String attivato_prod,String bsrUriSLD) {

		String output = null;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}

			Document document = docBuilder.newDocument();

			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAME, name));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAMESPACE, ""));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.VERSION, ""));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.DESCRIPTION, description));
			
			propertiesElement.appendChild(createPropertyElement(document, "gpx63_DATA_ULTIMO_UTILIZZO_LEGAME_APPL", attivato_appl));
			propertiesElement.appendChild(createPropertyElement(document, "gpx63_DATA_ULTIMO_UTILIZZO_LEGAME_SYST", attivato_syst));
			propertiesElement.appendChild(createPropertyElement(document, "gpx63_DATA_ULTIMO_UTILIZZO_LEGAME_PROD", attivato_prod));

			propertiesElement.appendChild(
					createPropertyElement(document, PropertyConstants.PRIMARY_TYPE, OWL_SERVICE_LEVEL_AGREEMENT));

			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GPX63_PEAK_MESSAGE_RETAIL_DURATION, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GPX63_PEAK_MESSAGE_RETAIL_TIME, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_VERSION_MATCH_CRITERIA, "ExactVersion"));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_GEP63_CONTEXT_IDENTIFIER, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_GPX63_MAXIMUM_MESSAGE_PERDAY, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_GPX63_AVERAGE_MESSAGE_PERDAY, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_GPX63_PEAK_MESSAGE_RATE, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_GPX63_MINIMUM_MESSAGE_PERDAY, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_SUBSCRIPTION_TERMINATE_DATE, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_SUBSCRIPTION_AVALILABILITY_DATE, EMPTY_STRING));
			
			//last added
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GPX63_RUNTIME , EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GPX63_DESIGNTIME , EMPTY_STRING));
			//09/12/2016
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GPX63_USERDEFTIME , EMPTY_STRING));
			
			// Relationships element
			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);

			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_BOUND_SCA_IMPORT, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_SERVICE_LEVEL_POLICIES, null));
			String targetUri = (bsrUriSLD == null) ? null : bsrUriSLD;
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_AGREED_ENDPOINTS, targetUri));
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");

		} catch (Exception e) {
			e.printStackTrace();
			output = null;
		}

		return output;
	}

	//25/10/2016 aggiunti gep63_DATA_PUBBLICAZIONE e gep63_PUBBLICATORE_SERV e i dati x reps0
	//03/02/2018 aggiunti gep63_SOPEN_ABILITAZ_READ - gep63_SOPEN_ABILITAZ_WRITE - gep63_SOPEN_MOD_UTENTI_BUS
	//28/02/2018 aggiunto gep63_SCHOST_ACRONIMO_RTC
	//05/06/2018 aggiunti i tre campi: gep63_CAT_SERVIZIO - gep63_CAT_INPUT - gep63_CAT_OUTPUT
	public String createApplicationVersionXMLData(String name, String bsrUriOrganization) {

		String output = null;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}

			Document document = docBuilder.newDocument();

			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAME, name));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAMESPACE, ""));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.VERSION, "00"));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.DESCRIPTION, ""));

			//12017 allineati i campi al nuovo modello
			propertiesElement.appendChild(createPropertyElement(document, "gep63_DESC_ESTESA", EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, "gep63_DOC_ANALISI_FUNZIONALE", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_DOC_ANALISI_TECNICA", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_DATA_ULTIMO_UTILIZZO", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_ATTIVATO_IN_PROD", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_PID_PROCESSO_GOV", EMPTY_STRING));

			propertiesElement.appendChild(createPropertyElement(document, "gep63_ATTIVATO_IN_APPL", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_ATTIVATO_IN_SYST", EMPTY_STRING));
			
			//capability version
            propertiesElement.appendChild(createPropertyElement(document, "gep63_ABILITAZ_INFRASTR",EMPTY_STRING));
            propertiesElement.appendChild(createPropertyElement(document, "gep63_FLG_CTRL_TIPOLOGIA",EMPTY_STRING));
            propertiesElement.appendChild(createPropertyElement(document, "gep63_UTILIZ_PIU_BAN_CLONI", EMPTY_STRING));
            propertiesElement.appendChild(createPropertyElement(document, "gep63_DISP_SERV", EMPTY_STRING));
            propertiesElement.appendChild(createPropertyElement(document, "gep63_VINCOLI_RIUSO", EMPTY_STRING));
            propertiesElement.appendChild(createPropertyElement(document, "gep63_INFO_COSTO", EMPTY_STRING));
            propertiesElement.appendChild(createPropertyElement(document, "gep63_PIATT_EROG", EMPTY_STRING));
            propertiesElement.appendChild(createPropertyElement(document, "gep63_DATA_RITIRO_SERV",EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_MATR_RICH_MODIFICA",EMPTY_STRING ));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_MATR_RICH_CREAZIONE",EMPTY_STRING ));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_DATA_PUBBL_CREAZ_SERV", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_MATR_PUBBLICATORE_CREAZ_SERV", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_TIPOLOGIA", EMPTY_STRING));
			
			//15032017
			propertiesElement.appendChild(createPropertyElement(document, "gep63_DERIVANTE_DA_ALTRI_SERV",EMPTY_STRING ));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_SECURITY_ROLE", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_NOME_SERVIZIO_PRECEDENTE", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_TIPOLOGIA_OGGETTO_ESISTENTE", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_DOC_ANALISI_DETTAGLIO", EMPTY_STRING));
			
			//03022018
			propertiesElement.appendChild(createPropertyElement(document, "gep63_SOPEN_ABILITAZ_READ",EMPTY_STRING ));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_SOPEN_ABILITAZ_WRITE", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_SOPEN_MOD_UTENTI_BUS", EMPTY_STRING));
			
			//28022018
			propertiesElement.appendChild(createPropertyElement(document, "gep63_SCHOST_ACRONIMO_RTC", EMPTY_STRING));
			
			//05062018
			propertiesElement.appendChild(createPropertyElement(document, "gep63_CAT_SERVIZIO", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_CAT_INPUT", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_CAT_OUTPUT", EMPTY_STRING));
			
			
			propertiesElement.appendChild(
					createPropertyElement(document, PropertyConstants.PRIMARY_TYPE, OWL_BUSINESS_APPLICATION_VERSION));

			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_WEB_LINK, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_ALE63_FULL_DESCRIPTION, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_REMOTE_STATE, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_TYPE, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_ALE63_REQUIREMENTS_LINK, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_OWNER_EMAIL, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_GUID, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_COMMUNITY_NAME, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_OWNERS, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_GEP63_CONSUMER_IDENTIFIER, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_VERSION_AVAILABILITY_DATE, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_VERSION_TERMINATION_DATE, EMPTY_STRING));

			// Relationships element
			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);

			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_ALE63_ARTIFACTS, null));
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDES, null));
			String targetUri = (bsrUriOrganization == null) ? null : bsrUriOrganization;
			relationshipsElement.appendChild(
					createRelationshipElement(document, RELATIONSHIP_ALE63_OWNING_ORGANIZATION, targetUri));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDED_REST_SERVICES, null));
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_CONSUMES, null));
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_ALE63_DEPENDENCY, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDED_WEB_SERVICES, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDED_SCA_MODULES, null));
			relationshipsElement.appendChild(
					createRelationshipElement(document, RELATIONSHIP_GEP63_INTERFACE_SPECIFICATIONS, null));

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");

		} catch (Exception e) {
			e.printStackTrace();
			output = null;
		}

		return output;
	}

	public String createBusinessServiceXMLData(TWList data, String serviceVersionBsrUri, String organizationBsrUri) {

		String output = null;

		String type = (String) data.getArrayData(1);
		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}

			/*
			 * Now create the XML document that represents the BusinessService
			 */
			Document document = docBuilder.newDocument();
			// Resources element
			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			// Resource element
			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			// Properties element
			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(
					createPropertyElement(document, PropertyConstants.NAME, (String) data.getArrayData(2)));

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.PRIMARY_TYPE,
					OWL_URI_ISP_SERVICE + type + "Service"));

			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_WEB_LINK, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_ALE63_FULL_DESCRIPTION, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_REMOTE_STATE, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_TYPE, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_ALE63_REQUIREMENTS_LINK, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_OWNER_EMAIL, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_GUID, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_COMMUNITY_NAME, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_OWNERS, EMPTY_STRING));

			// Relationships element
			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);

			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_ALE63_DEPENDENCY, null));
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_ALE63_ARTIFACTS, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_ALE63_OWNING_ORGANIZATION, null));
			relationshipsElement.appendChild(
					createRelationshipElement(document, RELATIONSHIP_GEP63_SERVICE_INTERFACE_VERSIONS, null));
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_CHARTER, null));
			relationshipsElement.appendChild(
					createRelationshipElement(document, RELATIONSHIP_GEP63_CAPABILITY_VERSIONS, serviceVersionBsrUri));
			//
			if (organizationBsrUri != null && !organizationBsrUri.equals("nf")) {
				relationshipsElement.appendChild(
						createRelationshipElement(document, "ale63_owningOrganization", organizationBsrUri));
			}

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");
			/*
			 * Process the HTTP response.
			 */

		} catch (Exception e) {
			e.printStackTrace();
			output = e.getMessage();
		}

		return output;
	}

	public String createRestInterfaceXMLData(String name, TWList data) {
		String output = null;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}

			Document document = docBuilder.newDocument();

			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAME, name));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAMESPACE, ""));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.DESCRIPTION, ""));

			propertiesElement
					.appendChild(createPropertyElement(document, PropertyConstants.PRIMARY_TYPE, OWL_REST_INTERFACE));

			propertiesElement.appendChild(createPropertyElement(document, "sm63_interfaceName", "X"));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_interfaceVersion", "X"));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_interfaceNamespace", "X"));
			propertiesElement.appendChild(createPropertyElement(document, "rest80_webLink", EMPTY_STRING));

			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);

			relationshipsElement.appendChild(createRelationshipElement(document, "sm63_wsdlPortTypes", null));
			relationshipsElement.appendChild(createRelationshipElement(document, "sm63_schemaDependencies", null));
			relationshipsElement.appendChild(createRelationshipElement(document, "sm63_operations", null));

			boolean definitiondocument = false;

			int size = data.getArraySize();
			for (int i = 0; i < size; i++) {
				String bsrURIDocument = (String) data.getArrayData(i);
				if (bsrURIDocument.length() != 0) {
					relationshipsElement.appendChild(createRelationToDocument(document, "rest80_definitionDocument",
							bsrURIDocument, "GenericDocument"));
					definitiondocument = true;
				}
			}

			if (!definitiondocument) {
				relationshipsElement
						.appendChild(createRelationshipElement(document, "rest80_definitionDocument", null));
			}

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");

		} catch (Exception e) {
			e.printStackTrace();
			output = e.getMessage();
		}
		return output;
	}

	public String createServiceSCOPENServiceVersionXMLDAta(TWList data, String sdlBsrUri, String organizationBsrUri) {

		String output = null;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}
			/*
			 * Now create the XML document that represents the BusinessService
			 */
			Document document = docBuilder.newDocument();

			// Resources element
			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			// Resource element
			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			// Properties element
			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(
					createPropertyElement(document, PropertyConstants.NAME, (String) data.getArrayData(2)));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAMESPACE, ""));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.VERSION, "00"));
			propertiesElement.appendChild(
					createPropertyElement(document, PropertyConstants.DESCRIPTION, (String) data.getArrayData(5)));

			propertiesElement
					.appendChild(createPropertyElement(document, "gep63_DESC_ESTESA", (String) data.getArrayData(6)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_DOC_ANALISI_FUNZIONALE", (String) data.getArrayData(7)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_DOC_ANALISI_TECNICA", (String) data.getArrayData(8)));
			// propertiesElement.appendChild(createPropertyElement(document,
			// "gep63_DATA_ULTIMO_UTILIZZO", (String) data.getArrayData(9)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_ATTIVATO_IN_PROD", (String) data.getArrayData(10)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_PID_PROCESSO_GOV", (String) data.getArrayData(11)));

			propertiesElement.appendChild(createPropertyElement(document, "gep63_ATTIVATO_IN_APPL", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_ATTIVATO_IN_SYST", EMPTY_STRING));

			// costruisco il primary type dell'oggetto

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.PRIMARY_TYPE,
					OWL_URI_ISP_SERVICE_VERSION + "SCOPENServiceVersion"));

			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_WEB_LINK, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_ALE63_FULL_DESCRIPTION, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_REMOTE_STATE, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_TYPE, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_ALE63_REQUIREMENTS_LINK, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_OWNER_EMAIL, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_GUID, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_COMMUNITY_NAME, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_OWNERS, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_GEP63_CONSUMER_IDENTIFIER, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_VERSION_AVAILABILITY_DATE, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_VERSION_TERMINATION_DATE, EMPTY_STRING));

			// Relationships element
			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);

			relationshipsElement.appendChild(
					createRelationshipElement(document, RELATIONSHIP_ALE63_DEPENDENCY, null));
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_ALE63_ARTIFACTS, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_ALE63_OWNING_ORGANIZATION, organizationBsrUri));
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_CONSUMES, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDES, sdlBsrUri));
			relationshipsElement.appendChild(
					createRelationshipElement(document, RELATIONSHIP_GEP63_INTERFACE_SPECIFICATIONS, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDED_SCA_MODULES, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDED_WEB_SERVICES, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDED_REST_SERVICES, null));

			// Classifications element
			String classificazione = (String) data.getArrayData(0);
			Element classificationsElement = document.createElement(ELEMENT_CLASSIFICATIONS);
			resourceElement.appendChild(classificationsElement);
			classificationsElement.appendChild(classificationsElement
					.appendChild(createClassificationElement(document, "http://isp/#" + classificazione)));

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");

		} catch (Exception e) {
			e.printStackTrace();
			output = null;
		}

		return output;
	}

	public String createServiceSHOSTServiceVersionXMLDAta(TWList data, String sdlBsrUri, String organizationBsrUri) {

		String output = null;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}
			/*
			 * Now create the XML document that represents the BusinessService
			 */
			Document document = docBuilder.newDocument();

			// Resources element
			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			// Resource element
			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			// Properties element
			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(
					createPropertyElement(document, PropertyConstants.NAME, (String) data.getArrayData(2)));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAMESPACE, ""));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.VERSION, "00"));
			propertiesElement.appendChild(
					createPropertyElement(document, PropertyConstants.DESCRIPTION, (String) data.getArrayData(9)));

			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_SHOST_PGM_SERVIZIO", (String) data.getArrayData(3)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_SHOST_TRANS_SERVIZIO", (String) data.getArrayData(4)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_SHOST_ID_SERVIZIO", (String) data.getArrayData(5)));
			propertiesElement
					.appendChild(createPropertyElement(document, "gep63_SHOST_PGM_MD", (String) data.getArrayData(6)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_SHOST_CONVNULL", (String) data.getArrayData(7)));

			propertiesElement
					.appendChild(createPropertyElement(document, "gep63_DESC_ESTESA", (String) data.getArrayData(10)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_DOC_ANALISI_FUNZIONALE", (String) data.getArrayData(11)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_DOC_ANALISI_TECNICA", (String) data.getArrayData(12)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_ATTIVATO_IN_PROD", (String) data.getArrayData(14)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_PID_PROCESSO_GOV", (String) data.getArrayData(15)));

			propertiesElement.appendChild(createPropertyElement(document, "gep63_ATTIVATO_IN_APPL", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_ATTIVATO_IN_SYST", EMPTY_STRING));

			// costruisco il primary type dell'oggetto

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.PRIMARY_TYPE,
					OWL_URI_ISP_SERVICE_VERSION + "SHOSTServiceVersion"));

			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_WEB_LINK, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_ALE63_FULL_DESCRIPTION, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_REMOTE_STATE, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_TYPE, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_ALE63_REQUIREMENTS_LINK, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_OWNER_EMAIL, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_GUID, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_COMMUNITY_NAME, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_OWNERS, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_GEP63_CONSUMER_IDENTIFIER, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_VERSION_AVAILABILITY_DATE, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_VERSION_TERMINATION_DATE, EMPTY_STRING));

			// Relationships element
			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);
			
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_ALE63_DEPENDENCY, null));
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_ALE63_ARTIFACTS, null));
			relationshipsElement.appendChild(
					createRelationshipElement(document, RELATIONSHIP_ALE63_OWNING_ORGANIZATION, organizationBsrUri));
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_CONSUMES, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDES, sdlBsrUri));
			relationshipsElement.appendChild(
					createRelationshipElement(document, RELATIONSHIP_GEP63_INTERFACE_SPECIFICATIONS, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDED_SCA_MODULES, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDED_WEB_SERVICES, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDED_REST_SERVICES, null));

			/*
			 * aggiungo le relazioni per copycobol Obbligatorie ed eventualmente
			 * i due xsd (opzionali)
			 * 
			 */

			String now = (String) data.getArrayData(16); // xsddfdlinput
			if (now != "") {
				relationshipsElement
						.appendChild(createRelationToDocument(document, "gep63_SHOST_DFDL_INP", now, "XSDDocument"));
			} else {
				relationshipsElement
						.appendChild(createRelationToDocument(document, "gep63_SHOST_DFDL_INP", null, null));
			}
			now = (String) data.getArrayData(17); // xsddfdloutput
			if (now != "") {
				relationshipsElement
						.appendChild(createRelationToDocument(document, "gep63_SHOST_DFDL_OUT", now, "XSDDocument"));
			} else {
				relationshipsElement
						.appendChild(createRelationToDocument(document, "gep63_SHOST_DFDL_OUT", null, null));
			}

			// copy cobol sono obbligatori e di tipo GenericDocument
			now = (String) data.getArrayData(18); // cpycobolInp
			if (now != "") {
				relationshipsElement
						.appendChild(createRelationToDocument(document, "gep63_SHOST_CPY_INP", now, "GenericDocument")); 
			}
			now = (String) data.getArrayData(19); // cpycobolOut
			if (now != "") {
				relationshipsElement
						.appendChild(createRelationToDocument(document, "gep63_SHOST_CPY_OUT", now, "GenericDocument")); 
			}

			// Classifications element
			String classificazione = (String) data.getArrayData(0);
			Element classificationsElement = document.createElement(ELEMENT_CLASSIFICATIONS);
			resourceElement.appendChild(classificationsElement);
			classificationsElement.appendChild(classificationsElement
					.appendChild(createClassificationElement(document, "http://isp/#" + classificazione)));

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");

		} catch (Exception e) {
			e.printStackTrace();
			output = null;
		}

		return output;
	}

	public String createServiceSCHOSTServiceVersionXMLDAta(TWList data, String sdlBsrUri, String organizationBsrUri) {

		String output = null;

		try {

			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				output = e.getMessage();
				throw e;

			}
			/*
			 * Now create the XML document that represents the BusinessService
			 */
			Document document = docBuilder.newDocument();

			// Resources element
			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			// Resource element
			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			// Properties element
			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(
					createPropertyElement(document, PropertyConstants.NAME, (String) data.getArrayData(2)));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAMESPACE, ""));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.VERSION, "00"));
			propertiesElement.appendChild(
					createPropertyElement(document, PropertyConstants.DESCRIPTION, (String) data.getArrayData(9)));

			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_SCHOST_TRANS_SERVIZIO", (String) data.getArrayData(3)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_SCHOST_ID_SERVIZIO", (String) data.getArrayData(4)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_SCHOST_COD_VERSIONE", (String) data.getArrayData(5)));
			propertiesElement
					.appendChild(createPropertyElement(document, "gep63_SCHOST_PGM_MD", (String) data.getArrayData(6)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_SCHOST_CONVNULL", (String) data.getArrayData(7)));

			propertiesElement
					.appendChild(createPropertyElement(document, "gep63_DESC_ESTESA", (String) data.getArrayData(10)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_DOC_ANALISI_FUNZIONALE", (String) data.getArrayData(11)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_DOC_ANALISI_TECNICA", (String) data.getArrayData(12)));

			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_ATTIVATO_IN_PROD", (String) data.getArrayData(14)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_PID_PROCESSO_GOV", (String) data.getArrayData(15)));

			propertiesElement.appendChild(createPropertyElement(document, "gep63_ATTIVATO_IN_APPL", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_ATTIVATO_IN_SYST", EMPTY_STRING));

			// costruisco il primary type dell'oggetto

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.PRIMARY_TYPE,
					OWL_URI_ISP_SERVICE_VERSION + "SCHOSTServiceVersion"));

			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_WEB_LINK, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_ALE63_FULL_DESCRIPTION, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_REMOTE_STATE, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_TYPE, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_ALE63_REQUIREMENTS_LINK, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_OWNER_EMAIL, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_GUID, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_COMMUNITY_NAME, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_OWNERS, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_GEP63_CONSUMER_IDENTIFIER, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_VERSION_AVAILABILITY_DATE, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_VERSION_TERMINATION_DATE, EMPTY_STRING));

			// Relationships element
			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);

			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_ALE63_DEPENDENCY, null));
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_ALE63_ARTIFACTS, null));
			relationshipsElement.appendChild(
					createRelationshipElement(document, RELATIONSHIP_ALE63_OWNING_ORGANIZATION, organizationBsrUri));
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_CONSUMES, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDES, sdlBsrUri));
			relationshipsElement.appendChild(
					createRelationshipElement(document, RELATIONSHIP_GEP63_INTERFACE_SPECIFICATIONS, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDED_SCA_MODULES, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDED_WEB_SERVICES, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDED_REST_SERVICES, null));

			/*
			 * aggiungo le relazioni per copycobol Obbligatorie ed eventualmente
			 * i due xsd (opzionali)
			 * 
			 */

			String now = (String) data.getArrayData(16); // xsddfdlinput
			if (now != "") {
				relationshipsElement
						.appendChild(createRelationToDocument(document, "gep63_SCHOST_DFDL_INP", now, "XSDDocument"));
			} else {
				relationshipsElement
						.appendChild(createRelationToDocument(document, "gep63_SCHOST_DFDL_INP", null, null));
			}
			now = (String) data.getArrayData(17); // xsddfdloutput
			if (now != "") {
				relationshipsElement
						.appendChild(createRelationToDocument(document, "gep63_SCHOST_DFDL_OUT", now, "XSDDocument"));
			} else {
				relationshipsElement
						.appendChild(createRelationToDocument(document, "gep63_SCHOST_DFDL_OUT", null, null));
			}

			// copy cobol sono obbligatori e di tipo GenericDocument

			now = (String) data.getArrayData(18);// cpycobolInp
			if (now != "") {
				relationshipsElement.appendChild(
						createRelationToDocument(document, "gep63_SCHOST_CPY_INP", now, "GenericDocument")); 
																									
			}
			now = (String) data.getArrayData(19); // cpycobolOut
			if (now != "") {
				relationshipsElement.appendChild(
						createRelationToDocument(document, "gep63_SCHOST_CPY_OUT", now, "GenericDocument")); 
			}

			// Classifications element
			String classificazione = (String) data.getArrayData(0);
			Element classificationsElement = document.createElement(ELEMENT_CLASSIFICATIONS);
			resourceElement.appendChild(classificationsElement);
			classificationsElement.appendChild(classificationsElement
					.appendChild(createClassificationElement(document, "http://isp/#" + classificazione)));

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");

		} catch (Exception e) {
			e.printStackTrace();
			output = e.getMessage();
		}

		return output;
	}

	private Element createPropertyElement(Document document, String name, String value) {
		Element element = document.createElement(ELEMENT_PROPERTY);
		element.setAttribute(ATTR_NAME, name);
		element.setAttribute(ATTR_VALUE, value);
		return element;
	}

	private Element createClassificationElement(Document document, String classification) {
		Element element = document.createElement(ELEMENT_CLASSIFICATION);
		element.setAttribute(ATTR_URI, classification);
		return element;
	}

	private Element createRelationshipElement(Document document, String name, String targetBsrUri) {
		Element element = document.createElement(ELEMENT_RELATIONSHIP);
		element.setAttribute(ATTR_NAME, name);
		if (targetBsrUri != null) {
			element.setAttribute(ATTR_TARGET_BSRURI, targetBsrUri);
		}
		return element;
	}

	private Element createRelationshipElementServiceInterface(Document document, String targetBsrUri) {
		Element element = document.createElement(ELEMENT_RELATIONSHIP);
		element.setAttribute(ATTR_NAME, "gep63_serviceInterface");
		if (targetBsrUri != null) {
			element.setAttribute(ATTR_TARGET_BSRURI, targetBsrUri);
		}
		element.setAttribute(ATTR_TARGET_TYPE, "GenericObject");
		element.setAttribute(ATTR_PRIMARY_TYPE, OWL_REST_INTERFACE);
		return element;
	}

	private Element createRelationshipElementEndpoint(Document document, String interfacetype, String targetBsrUri) {
		Element element = document.createElement(ELEMENT_RELATIONSHIP);
		element.setAttribute(ATTR_NAME, "gep63_availableEndpoints");
		if (targetBsrUri != null) {
			element.setAttribute(ATTR_TARGET_BSRURI, targetBsrUri);
		}
		String type = "";
		if (interfacetype == null)
			interfacetype = "REST";

		switch (interfacetype) {
		case "REST":
			type = OWL_REST_ENDPOINT;
			break;
		case "SOAP":
			type = OWL_SOAP_ENDPOINT;
			break;
		case "CICS":
			type = OWL_CICS_ENDPOINT;
			break;
		case "MQ":
			type = OWL_MQ_ENDPOINT;
			break;
		default:
			type = OWL_REST_ENDPOINT;
			break;
		}
		element.setAttribute(ATTR_TARGET_TYPE, "GenericObject");
		element.setAttribute(ATTR_PRIMARY_TYPE, type);
		return element;
	}

	private Element createRelationToDocument(Document document, String name, String targetBsrURI,
			String targetDocumentType) {

		Element element = document.createElement(ELEMENT_RELATIONSHIP);
		element.setAttribute(ATTR_NAME, name);
		if (targetBsrURI != null) {
			element.setAttribute(ATTR_TARGET_BSRURI, targetBsrURI);
		}
		if (targetDocumentType != null) {
			element.setAttribute(ATTR_TARGET_TYPE, targetDocumentType);
		}

		return element;
	}

	public String getItems(TWList items) {
		StringBuffer buffer = new StringBuffer();
		int size = items.getArraySize();
		for (int i = 0; i < size; i++) {
			String member = (String) items.getArrayData(i);
			buffer.append(member);
			if (i < (size - 1)) {
				buffer.append(',');
			}
		}
		return buffer.toString();
	}

	public String getItemsWSRR(TWList items, int indice) {
		return (String) items.getArrayData(indice);
	}

	public String createServiceSOPENServiceVersionXMLDAta(TWList data, String sdlBsrUri, String organizationBsrUri) {

		String output = null;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}
			/*
			 * Now create the XML document that represents the BusinessService
			 */
			Document document = docBuilder.newDocument();

			// Resources element
			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			// Resource element
			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			// Properties element
			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(
					createPropertyElement(document, PropertyConstants.NAME, (String) data.getArrayData(2)));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAMESPACE, ""));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.VERSION, "00"));
			propertiesElement.appendChild(
					createPropertyElement(document, PropertyConstants.DESCRIPTION, (String) data.getArrayData(5)));

			propertiesElement
					.appendChild(createPropertyElement(document, "gep63_DESC_ESTESA", (String) data.getArrayData(6)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_DOC_ANALISI_FUNZIONALE", (String) data.getArrayData(7)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_DOC_ANALISI_TECNICA", (String) data.getArrayData(8)));
			// propertiesElement.appendChild(createPropertyElement(document,
			// "gep63_DATA_ULTIMO_UTILIZZO", (String) data.getArrayData(9)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_ATTIVATO_IN_PROD", (String) data.getArrayData(10)));
			propertiesElement.appendChild(
					createPropertyElement(document, "gep63_PID_PROCESSO_GOV", (String) data.getArrayData(11)));

			propertiesElement.appendChild(createPropertyElement(document, "gep63_ATTIVATO_IN_APPL", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "gep63_ATTIVATO_IN_SYST", EMPTY_STRING));

			// costruisco il primary type dell'oggetto

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.PRIMARY_TYPE,
					OWL_URI_ISP_SERVICE_VERSION + "SOPENServiceVersion"));

			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_WEB_LINK, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_ALE63_FULL_DESCRIPTION, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_REMOTE_STATE, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_TYPE, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_ALE63_REQUIREMENTS_LINK, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_OWNER_EMAIL, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_GUID, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_COMMUNITY_NAME, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_ASSET_OWNERS, EMPTY_STRING));
			propertiesElement
					.appendChild(createPropertyElement(document, PROPERTY_GEP63_CONSUMER_IDENTIFIER, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_VERSION_AVAILABILITY_DATE, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_VERSION_TERMINATION_DATE, EMPTY_STRING));

			// Relationships element
			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);

			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_ALE63_DEPENDENCY, null));
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_ALE63_ARTIFACTS, null));
			relationshipsElement.appendChild(
					createRelationshipElement(document, RELATIONSHIP_ALE63_OWNING_ORGANIZATION, organizationBsrUri));
			relationshipsElement.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_CONSUMES, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDES, sdlBsrUri));
			relationshipsElement.appendChild(
					createRelationshipElement(document, RELATIONSHIP_GEP63_INTERFACE_SPECIFICATIONS, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDED_SCA_MODULES, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDED_WEB_SERVICES, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_PROVIDED_REST_SERVICES, null));

			// Classifications element
			String classificazione = (String) data.getArrayData(0);
			Element classificationsElement = document.createElement(ELEMENT_CLASSIFICATIONS);
			resourceElement.appendChild(classificationsElement);
			classificationsElement.appendChild(classificationsElement
					.appendChild(createClassificationElement(document, "http://isp/#" + classificazione)));

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");

		} catch (Exception e) {
			e.printStackTrace();
			output = null;
		}

		return output;
	}

	public String createRestEndpointXMLDAta(String name, String timeout, String environment, String state) {

		String output = null;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}

			Document document = docBuilder.newDocument();

			// Resources element
			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			// Resource element
			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			// Properties element
			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAME, name));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAMESPACE, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.VERSION, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.DESCRIPTION, EMPTY_STRING));

			propertiesElement.appendChild(createPropertyElement(document, "sm63_serviceNamespace", "X"));
			propertiesElement.appendChild(createPropertyElement(document, "rest80_baseURL", "X"));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_endpointType", "REST"));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_serviceName", "X"));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_Timeout", timeout));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_serviceVersion", "X"));

			propertiesElement.appendChild(createPropertyElement(document, "sm63_DATA_PRIMO_UTILIZZO", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_DATA_ULTIMO_UTILIZZO", EMPTY_STRING));

			propertiesElement
					.appendChild(createPropertyElement(document, PropertyConstants.PRIMARY_TYPE, OWL_REST_ENDPOINT));

			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);

			relationshipsElement.appendChild(createRelationshipElement(document, "sm63_sourceDocument", null));

			Element classificationsElement = document.createElement(ELEMENT_CLASSIFICATIONS);
			resourceElement.appendChild(classificationsElement);
			classificationsElement.appendChild(classificationsElement
					.appendChild(createClassificationElement(document, OWL_ENVIRONMENT_STATE + environment)));


			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");

		} catch (Exception e) {
			e.printStackTrace();
			output = null;
		}
		return output;
	}

	public String createSoapEndpointXMLDAta(String name, String timeout, String environment, String state) {

		String output = null;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}

			Document document = docBuilder.newDocument();

			// Resources element
			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			// Resource element
			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			// Properties element
			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAME, name));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAMESPACE, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.VERSION, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.DESCRIPTION, EMPTY_STRING));

			propertiesElement.appendChild(createPropertyElement(document, "sm63_serviceNamespace", "X"));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_endpointType", "SOAP"));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_serviceName", "X"));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_Timeout", timeout));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_serviceVersion", "X"));

			propertiesElement.appendChild(createPropertyElement(document, "sm63_DATA_PRIMO_UTILIZZO", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_DATA_ULTIMO_UTILIZZO", EMPTY_STRING));

			propertiesElement
					.appendChild(createPropertyElement(document, PropertyConstants.PRIMARY_TYPE, OWL_SOAP_ENDPOINT));

			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);

			relationshipsElement.appendChild(createRelationshipElement(document, "sm63_sourceDocument", null));
			relationshipsElement.appendChild(createRelationshipElement(document, "sm63_soapAddress", null));
			relationshipsElement.appendChild(createRelationshipElement(document, "sm63_wsdlPorts", null));

			Element classificationsElement = document.createElement(ELEMENT_CLASSIFICATIONS);
			resourceElement.appendChild(classificationsElement);
			classificationsElement.appendChild(classificationsElement
					.appendChild(createClassificationElement(document, OWL_ENVIRONMENT_STATE + environment)));

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");

		} catch (Exception e) {
			e.printStackTrace();
			output = null;
		}
		return output;
	}

	public String createCicsEndpointXMLDAta(String name, String timeout, String stage, String environment,
			String state) {

		String output = null;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}

			Document document = docBuilder.newDocument();

			// Resources element
			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			// Resource element
			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			// Properties element
			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAME, name));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAMESPACE, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.VERSION, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.DESCRIPTION, EMPTY_STRING));

			propertiesElement.appendChild(createPropertyElement(document, "sm63_serviceNamespace", "X"));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_endpointType", "CICS"));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_Stage", stage)); // cosa
																									// metto?
			propertiesElement.appendChild(createPropertyElement(document, "sm63_serviceName", "X"));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_Timeout", timeout));

			propertiesElement.appendChild(createPropertyElement(document, "sm63_DATA_PRIMO_UTILIZZO", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_DATA_ULTIMO_UTILIZZO", EMPTY_STRING));

			propertiesElement.appendChild(createPropertyElement(document, "sm63_serviceVersion", "X"));

			propertiesElement
					.appendChild(createPropertyElement(document, PropertyConstants.PRIMARY_TYPE, OWL_CICS_ENDPOINT));

			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);

			relationshipsElement.appendChild(createRelationshipElement(document, "sm63_sourceDocument", null));

			Element classificationsElement = document.createElement(ELEMENT_CLASSIFICATIONS);
			resourceElement.appendChild(classificationsElement);
			classificationsElement.appendChild(classificationsElement
					.appendChild(createClassificationElement(document, OWL_ENVIRONMENT_STATE + environment)));

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");

		} catch (Exception e) {
			e.printStackTrace();
			output = null;
		}
		return output;
	}

	public String createMqEndpointXMLDAta(String name, String timeout, String environment, String state) {

		String output = null;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}

			Document document = docBuilder.newDocument();

			// Resources element
			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			// Resource element
			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			// Properties element
			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAME, name));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAMESPACE, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.VERSION, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.DESCRIPTION, EMPTY_STRING));

			propertiesElement.appendChild(createPropertyElement(document, "sm63_serviceNamespace", "X"));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_portName", "X"));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_endpointType", "MQ"));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_serviceName", "X"));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_Timeout", timeout));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_serviceVersion", "X"));

			propertiesElement.appendChild(createPropertyElement(document, "sm63_DATA_PRIMO_UTILIZZO", EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, "sm63_DATA_ULTIMO_UTILIZZO", EMPTY_STRING));

			propertiesElement
					.appendChild(createPropertyElement(document, PropertyConstants.PRIMARY_TYPE, OWL_MQ_ENDPOINT));

			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);

			relationshipsElement.appendChild(createRelationshipElement(document, "sm63_sourceDocument", null));
			relationshipsElement.appendChild(createRelationshipElement(document, "sm63_mqEndpoint", null));

			Element classificationsElement = document.createElement(ELEMENT_CLASSIFICATIONS);
			resourceElement.appendChild(classificationsElement);
			classificationsElement.appendChild(classificationsElement
					.appendChild(createClassificationElement(document, OWL_ENVIRONMENT_STATE + environment)));

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");

		} catch (Exception e) {
			e.printStackTrace();
			output = null;
		}
		return output;
	}

	public String createServiceLevelDefinitionXMLData(String name, String interfacetype, String bsrURIInterface,
			TWList data) {

		// Create the variable to return
		String output;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}

			Document document = docBuilder.newDocument();

			// Resources element
			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			// Resource element
			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			// Properties element
			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAME, name));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.PRIMARY_TYPE, OWL_URI_SLD));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.DESCRIPTION,interfacetype ));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_CONSUMER_IDENTIFIER_LOCATION, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_CONTEXT_IDENTIFIER_LOCATION, EMPTY_STRING));

			// Relationships element
			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);

			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_BOUND_SCA_EXPORT, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_ANONYMOUS_SLA, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_CAMPATIBLE_SLDS, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_BOUND_WEB_SERVICE_PORT, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_BOUND_REST_SERVICE, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_AVAILABLE_OPERATIONS, null));

			relationshipsElement.appendChild(this.createRelationshipElementServiceInterface(document, bsrURIInterface));

			int size = data.getArraySize();
			for (int i = 0; i < size; i++) {
				String bsrURIDocument = (String) data.getArrayData(i);
				relationshipsElement
						.appendChild(this.createRelationshipElementEndpoint(document, interfacetype, bsrURIDocument));
			}

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");

		} catch (Exception e) {
			e.printStackTrace();
			output = null;
		}

		return output;
	}

	public String createServiceLevelDefinitionXMLDataFuffa(String name, String interfacetype, String bsrURIInterface,
			String bsrURIendpoint) {

		// Create the variable to return
		String output;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}

			Document document = docBuilder.newDocument();

			// Resources element
			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			// Resource element
			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			// Properties element
			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAME, name));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.PRIMARY_TYPE, OWL_URI_SLD));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.DESCRIPTION, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_CONSUMER_IDENTIFIER_LOCATION, EMPTY_STRING));
			propertiesElement.appendChild(
					createPropertyElement(document, PROPERTY_GEP63_CONTEXT_IDENTIFIER_LOCATION, EMPTY_STRING));

			// Relationships element
			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);

			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_BOUND_SCA_EXPORT, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_ANONYMOUS_SLA, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_CAMPATIBLE_SLDS, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_BOUND_WEB_SERVICE_PORT, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_BOUND_REST_SERVICE, null));
			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_AVAILABLE_OPERATIONS, null));

			relationshipsElement.appendChild(this.createRelationshipElementServiceInterface(document, bsrURIInterface));
			relationshipsElement
					.appendChild(this.createRelationshipElementEndpoint(document, interfacetype, bsrURIendpoint));

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");
			System.out.println(">> " + output);

		} catch (Exception e) {
			e.printStackTrace();
			output = null;
		}

		return output;
	}

	public String createOrganizationXMLData(String name) {

		String output = null;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}

			/*
			 * Now create the XML document that represents the BusinessService
			 */
			Document document = docBuilder.newDocument();
			// Resources element
			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			// Resource element
			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			// Properties element
			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAME, name));

			propertiesElement
					.appendChild(createPropertyElement(document, PropertyConstants.PRIMARY_TYPE, OWL_ORGANIZATION));

			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_CONTACT, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_CONTACT_EMAIL, EMPTY_STRING));

			// Relationships element
			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);

			relationshipsElement
					.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_CHILD_ORGANIZATIONS, null));

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");


		} catch (Exception e) {
			e.printStackTrace();
			output = e.getMessage();
		}

		return output;
	}

	
	/**
	<property name="ale63_RESP_UFFICIO_MATRICOLA" value=""/>
	<property name="ale63_CODICE_SISTEMA_APPLICATIVO" value=""/>
	<property name="ale63_RESP_FUNZIONALE_NOMINATIVO" value=""/>
	<property name="ale63_RESP_SERVIZIO_NOMINATIVO" value=""/
	<property name="ale63_RESP_TECNICO_MATRICOLA" value=""/>
	<property name="ale63_RESP_ATTIVITA_NOMINATIVO" value=""/>
	<property name="ale63_RESP_ATTIVITA_MATRICOLA" value=""/>
	<property name="ale63_RESP_TECNICO_NOMINATIVO" value=""/>
	<property name="ale63_RESP_FUNZIONALE_MATRICOLA" value=""/>
	<property name="ale63_RESP_SERVIZIO_MATRICOLA" value=""/>
	<property name="ale63_RESP_UFFICIO_NOMINATIVO" value=""/>
	 */
	
	public String createOrganizationXMLDataExtended(String name, String description,String resp_uff_matr,String codice_sist_appl,String resp_funz_nom,String resp_serv_nom,String resp_tecn_matr,
			String resp_att_nom,String resp_att_matr,String resp_tecn_nom,String resp_funz_matr,String resp_serv_matr,String resp_uff_nom,String bsrUrilinkedOrg,String classification) {

		String output = null;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}

			/*
			 * Now create the XML document that represents the BusinessService
			 */
			Document document = docBuilder.newDocument();
			// Resources element
			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			// Resource element
			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			// Properties element
			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAME, name));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.DESCRIPTION, description));

			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_UFFICIO_MATRICOLA" , resp_uff_matr));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_CODICE_SISTEMA_APPLICATIVO" , codice_sist_appl));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_FUNZIONALE_NOMINATIVO" , resp_funz_nom));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_SERVIZIO_NOMINATIVO" , resp_serv_nom));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_TECNICO_MATRICOLA" , resp_tecn_matr));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_ATTIVITA_NOMINATIVO" , resp_att_nom));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_ATTIVITA_MATRICOLA" , resp_att_matr));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_TECNICO_NOMINATIVO" , resp_tecn_nom));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_FUNZIONALE_MATRICOLA" , resp_funz_matr));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_SERVIZIO_MATRICOLA" , resp_serv_matr));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_UFFICIO_NOMINATIVO" , resp_uff_nom));

			propertiesElement
					.appendChild(createPropertyElement(document, PropertyConstants.PRIMARY_TYPE, OWL_ORGANIZATION));

			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_CONTACT, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_CONTACT_EMAIL, EMPTY_STRING));

			// Relationships element
			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);
			
			String targetUri = (bsrUrilinkedOrg == null) ? null : bsrUrilinkedOrg;
			
			relationshipsElement
			.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_CHILD_ORGANIZATIONS, targetUri));
			
			
			//classifications

			String current_classification="";
			
			//no default value so generate error
			if (classification.equalsIgnoreCase("SSA")) current_classification=ISP_SSA_CLASSIFICATION;			
			if (classification.equalsIgnoreCase("ACRONIMO")) current_classification=ISP_ACRONIMO_CLASSIFICATION;
			
			Element classificationsElement = document.createElement(ELEMENT_CLASSIFICATIONS);
			resourceElement.appendChild(classificationsElement);
			classificationsElement.appendChild(classificationsElement
					.appendChild(createClassificationElement(document, current_classification)));
			
			

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");


		} catch (Exception e) {
			e.printStackTrace();
			output = e.getMessage();
		}

		return output;
	}
	
	//24/10/2016 + ambito e desc_ambito
	public String createOrganizationXMLDataExtendedAmbito(String name, String description,String resp_uff_matr,String codice_sist_appl,String resp_funz_nom,String resp_serv_nom,String resp_tecn_matr,
			String resp_att_nom,String resp_att_matr,String resp_tecn_nom,String resp_funz_matr,String resp_serv_matr,String resp_uff_nom,String bsrUrilinkedOrg,String classification,String ambito,String ambito_descr) {

		String output = null;

		try {
			try {
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();

				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPath xPath = xPathFactory.newXPath();
				valueAttrExpression = xPath.compile(XPATH_EXPR_VALUE_ATTR);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				throw e;
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw e;
			}

			/*
			 * Now create the XML document that represents the BusinessService
			 */
			Document document = docBuilder.newDocument();
			// Resources element
			Element resourcesElement = document.createElement(ELEMENT_RESOURCES);
			document.appendChild(resourcesElement);

			// Resource element
			Element resourceElement = document.createElement(ELEMENT_RESOURCE);
			resourcesElement.appendChild(resourceElement);

			// Properties element
			Element propertiesElement = document.createElement(ELEMENT_PROPERTIES);
			resourceElement.appendChild(propertiesElement);

			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.NAME, name));
			propertiesElement.appendChild(createPropertyElement(document, PropertyConstants.DESCRIPTION, description));

			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_UFFICIO_MATRICOLA" , resp_uff_matr));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_CODICE_SISTEMA_APPLICATIVO" , codice_sist_appl));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_FUNZIONALE_NOMINATIVO" , resp_funz_nom));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_SERVIZIO_NOMINATIVO" , resp_serv_nom));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_TECNICO_MATRICOLA" , resp_tecn_matr));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_ATTIVITA_NOMINATIVO" , resp_att_nom));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_ATTIVITA_MATRICOLA" , resp_att_matr));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_TECNICO_NOMINATIVO" , resp_tecn_nom));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_FUNZIONALE_MATRICOLA" , resp_funz_matr));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_SERVIZIO_MATRICOLA" , resp_serv_matr));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_RESP_UFFICIO_NOMINATIVO" , resp_uff_nom));

			//24/10/2016
			propertiesElement.appendChild(createPropertyElement(document,"ale63_AMBITO" , ambito));
			propertiesElement.appendChild(createPropertyElement(document,"ale63_DESC_AMBITO" , ambito_descr));

			propertiesElement
					.appendChild(createPropertyElement(document, PropertyConstants.PRIMARY_TYPE, OWL_ORGANIZATION));

			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_CONTACT, EMPTY_STRING));
			propertiesElement.appendChild(createPropertyElement(document, PROPERTY_ALE63_CONTACT_EMAIL, EMPTY_STRING));

			// Relationships element
			Element relationshipsElement = document.createElement(ELEMENT_RELATIONSHIPS);
			resourceElement.appendChild(relationshipsElement);
			
			String targetUri = (bsrUrilinkedOrg == null) ? null : bsrUrilinkedOrg;
			
			relationshipsElement
			.appendChild(createRelationshipElement(document, RELATIONSHIP_GEP63_CHILD_ORGANIZATIONS, targetUri));
			
			
			//classifications

			String current_classification="";
			
			//no default value so generate error
			if (classification.equalsIgnoreCase("SSA")) current_classification=ISP_SSA_CLASSIFICATION;			
			if (classification.equalsIgnoreCase("ACRONIMO")) current_classification=ISP_ACRONIMO_CLASSIFICATION;
			
			Element classificationsElement = document.createElement(ELEMENT_CLASSIFICATIONS);
			resourceElement.appendChild(classificationsElement);
			classificationsElement.appendChild(classificationsElement
					.appendChild(createClassificationElement(document, current_classification)));
			
			

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer1 = tf.newTransformer();
			transformer1.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer1.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");


		} catch (Exception e) {
			e.printStackTrace();
			output = e.getMessage();
		}

		return output;
	}
}
