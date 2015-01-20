<<<<<<< HEAD
<%@page import="com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.model.CreditAppStatus"%>
<%@page import="com.tamarack.creekridge.service.CreditAppLocalServiceUtil"%>
<%@page import="com.tamarack.liferay.payment.TempBankAccount"%>
<%@page import="com.liferay.util.*"%>
<%@page import="com.tamarack.liferay.payment.TempProposalOption"%>
<%@page import="com.tamarack.liferay.payment.TempPrincipal"%>
<%@page import="com.tamarack.creekridge.service.TermLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.PurchaseOptionLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.ProductLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.ProposalOptionLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.model.ProposalOption"%>
<%@page import="com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.model.CreditAppBankReference"%>
<%@page import="com.tamarack.creekridge.model.CreditApp"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="java.util.*"%>
<portlet:defineObjects />

<%
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
List<CreditApp> creditAppList=CreditAppLocalServiceUtil.getCreditApps(-1, -1);
List<CreditAppStatus> creditAppStatusList=CreditAppStatusLocalServiceUtil.getCreditAppStatuses(-1, -1);
boolean isOmniAdmin=themeDisplay.getPermissionChecker().isOmniadmin();
boolean isGroupOwner = themeDisplay.getPermissionChecker().isGroupOwner(themeDisplay.getScopeGroupId());
boolean isSiteMember =themeDisplay.getPermissionChecker().isGroupMember(themeDisplay.getScopeGroupId());
boolean isCreekRidgeSalesManager=false;
boolean isVendorSaleRep=false;
User user = themeDisplay.getUser();
if(isSiteMember) {
List<com.liferay.portal.model.UserGroupRole> userGroupRoles = com.liferay.portal.service.UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId());
List<com.liferay.portal.model.UserGroupRole> siteRoles = new ArrayList<com.liferay.portal.model.UserGroupRole>();
for (com.liferay.portal.model.UserGroupRole userGroupRole : userGroupRoles) {
	int roleType = userGroupRole.getRole().getType();
		if (roleType == com.liferay.portal.model.RoleConstants.TYPE_SITE) {
 			siteRoles.add(userGroupRole);
 			System.out.println(" Custom Role "+userGroupRole.getRole().getName());
 			if("salesManager".equalsIgnoreCase(userGroupRole.getRole().getName())){
	 			isCreekRidgeSalesManager=true;
				break;
			}
 		}
	}

if(!isCreekRidgeSalesManager) {
	for (com.liferay.portal.model.UserGroupRole userGroupRole : userGroupRoles) {
		int roleType = userGroupRole.getRole().getType();
			if (roleType == com.liferay.portal.model.RoleConstants.TYPE_SITE) {
 			siteRoles.add(userGroupRole);
 			System.out.println(" Custom Role "+userGroupRole.getRole().getName());
 			if("salesRep".equalsIgnoreCase(userGroupRole.getRole().getName())){
				isVendorSaleRep=true;
				break;
	         }
          }
      }
  }
}
Map<Long,String> statusMap= new HashMap<Long,String>();
for (int j=0;j<creditAppStatusList.size();j++){
	statusMap.put(creditAppStatusList.get(j).getCreditAppStatusId(), creditAppStatusList.get(j).getCreditAppStatusName());
}

%>
<portlet:actionURL var="updateCreditAppUrl" >
  <portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="updateCreditApp" />
</portlet:actionURL>
<html>
<portlet:renderURL var="viewCreditApplicationUrl">
	<portlet:param name="jspPage" value="/web/vendor1/payment-calculator" />
</portlet:renderURL>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<%-- <script src="<%=request.getContextPath() %>/js/jquery.dataTables.min.js"></script> --%>
<!-- <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.3/css/jquery.dataTables.css"> -->
<!-- jQuery -->
<!-- <script type="text/javascript" charset="utf8" src="//code.jquery.com/jquery-1.10.2.min.js"></script> -->
<!-- DataTables -->
<!-- <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.3/js/jquery.dataTables.js"></script> -->
 <style type="text/css" title="currentStyle">
            @import "<%=request.getContextPath() %>/css/viewCreditApp_page.css";
			@import "<%=request.getContextPath() %>/css/viewCreditApp_table.css";
			@import "http://jquery-datatables-column-filter.googlecode.com/svn/trunk/media/css/themes/base/jquery-ui.css";
			@import "http://jquery-datatables-column-filter.googlecode.com/svn/trunk/media/css/themes/smoothness/jquery-ui-1.7.2.custom.css";
		</style>
        <script src="<%=request.getContextPath() %>/js/jquery-1.4.4.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath() %>/js/jquery.dataTables.js" type="text/javascript"></script>

        <script src="<%=request.getContextPath() %>/js/jquery-ui.js" type="text/javascript"></script>

        <script src="<%=request.getContextPath() %>/js/jquery.dataTables.columnFilter.js" type="text/javascript"></script>


<script>
   $(document).ready(function () {
	   $.datepicker.regional[""].dateFormat = 'yy-mm-dd';
       $.datepicker.setDefaults($.datepicker.regional['']);
	   $('#creditAppView').DataTable()
	   .columnFilter({aoColumns:[
								    { type:"date-range", sSelector: "#createdDate" },
									{ type:"date-range", sSelector: "#lastSavedDate" },
									{ type:"date-range", sSelector: "#submittedDate" },
									{ type:"text", sSelector: "#customerName" },
									{ type:"text", sSelector: "#equipmentPrice" },
									{ type:"text", sSelector: "#creditApplicationStatus" }
									]}
								);

		
}); 


   function assignActionType(actionType, creditAppId) {
		
		
	   	document.<portlet:namespace />creditApp.<portlet:namespace />actionType.value = actionType;
	   	document.<portlet:namespace />creditApp.<portlet:namespace />creditAppId.value = creditAppId;
	   	document.<portlet:namespace />creditApp.submit();

	}

</script>
<style type="text/css">

.displayFilterTemp {
 
  border: 1px solid black ;
  margin: 5px;
  padding: 5px;
}

</style>
</head>



<div align="center" width="100%"  id="calculatorResults">
	<H4><font style="background-color: lightgrey">View Credit Application</font></H4>
</div>
<aui:form name="creditApp" action="<%=updateCreditAppUrl %>" method="post">
<aui:input type="hidden" value="" name="creditAppId" />
<aui:input type="hidden" value="" name="actionType" />

</aui:form>
<div id="creditAppFilter">
<table  class="display" ID="main">
<tr><td>
<table style="background-color: lightgrey; border: 1px solid black ; margin: 5px;  padding: 5px;" class="display" ID="Table1">
			<thead>
			<th>
			<b>Filters</b>
			</th>
			</thead>
			<tbody>
				<tr id="filter_global">
					<td align="center"><b>Created Date:</b></td>
				</tr>
				<tr>
					<td align="center" id="createdDate"></td>
				</tr>
				<tr id="filter_col1">
					<td align="center"><b>Last Saved Date:</b></td>
				</tr>
				<tr>
					<td align="center" id="lastSavedDate"></td>
				</tr>
				<tr id="filter_col2">
					<td align="center"><b>Submitted Date:</b></td>
				</tr>
				<tr>	
					<td align="center" id="submittedDate"></td>
				</tr>
				<tr id="filter_col3">
					<td align="center"><b>Customer Name:</b></td>
				 </tr>
				<tr>
					<td align="center" id="customerName"></td>
				</tr>
				<tr id="filter_col4">
					<td align="center">Equipment Price:</td>
				</tr>
				<tr>
					<td align="center" id="equipmentPrice"></td>
				</tr>
				<tr id="filter_col4">
					<td align="center"><b>Credit Application Status:</b></td>
				</tr>
				<tr>
					<td align="center" id="creditApplicationStatus"></td>
				</tr>
			</tbody>
		</table>
</td>
<td>		
 <table   id="creditAppView" class="display" >
 <thead>
    <tr>
			<th>Created Date</th>
			<th>Last Saved Date</th>
			<th>Submitted Date	</th>
			<th>Customer Name</th>
			<th>Equipment Price</th>
			<th>Credit Application Status</th>
			<th>View Action</th>
			<th>Cancel Action</th>
    </tr>
</thead>
<tfoot>

    <tr>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
    </tr>
</tfoot>

<tbody>

	<%  
	
      for (int i=0;i<creditAppList.size();i++) {
<<<<<<< HEAD
       if( !"Cancelled".equalsIgnoreCase(statusMap.get(creditAppList.get(i).getCreditAppStatusId())) && !"Draft".equalsIgnoreCase(statusMap.get(creditAppList.get(i).getCreditAppStatusId())))
=======
       if( !"Cancelled".equalsIgnoreCase(statusMap.get(creditAppList.get(i).getCreditAppStatusId())) && !"Cancelled".equalsIgnoreCase(statusMap.get(creditAppList.get(i).getCreditAppStatusId())))
>>>>>>> master
    	if((isVendorSaleRep && creditAppList.get(i).getUserId() == themeDisplay.getUserId()) || isCreekRidgeSalesManager || isOmniAdmin )  {
      %>

		<tr>
			<td> <%=creditAppList.get(i).getCreateDate()%>

			</td>
			<td><%=creditAppList.get(i).getModifiedDate()%>

			</td>
			<td><%=creditAppList.get(i).getModifiedDate()%>

			</td>
			<td><%=creditAppList.get(i).getCustomerName()%>
			</td>
			<td> <%=creditAppList.get(i).getEquipmentPrice()%>
			</td>
			<td> <%=statusMap.get(creditAppList.get(i).getCreditAppStatusId())%>
			</td>
			<%if( "Submitted".equalsIgnoreCase(statusMap.get(creditAppList.get(i).getCreditAppStatusId()))){ %>
			 <td><button  type="button"  name="view" value="View" onclick="<%="javascript:window.location.href='/web/vendor1/payment-calculator?viewOnly=true&creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><img src='<%= renderRequest.getContextPath() + "/images/edit.png" %>'/></button></td>
		     <%} else { %>
		      <td><button  type="button"  name="edit" value="Edit" onclick="<%="javascript:window.location.href='/web/vendor1/payment-calculator?creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><img src='<%= renderRequest.getContextPath() + "/images/edit.png" %>'/></button></td>
		    
		     <%} %>
		     
		     <%if( !"Submitted".equalsIgnoreCase(statusMap.get(creditAppList.get(i).getCreditAppStatusId()))){ %>
		      <td><button  type="button"  name="cancel"  value="Cancel" onclick="javascript:assignActionType('cancel','<%=creditAppList.get(i).getCreditAppId() %>')" ><img src='<%= renderRequest.getContextPath() + "/images/remove.png" %>' /></button></td>
	          <%} else { %>
	          <td>&nbsp;</td>
	           
	          <%} %>
		</tr>
	<%} 
	}%>
	</tbody>
	</table>
</td>
</tr>
</table>
</div>
<div class="spacer"></div>

=======


<!-- CHECK THIS OUT!!!!   http://www.liferay.com/documentation/liferay-portal/6.2/development/-/ai/creating-user-interfaces-for-service-bui-liferay-portal-6-2-dev-guide-04-en -->




<%@page import="com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.model.CreditAppStatus"%>
<%@page import="com.tamarack.creekridge.service.CreditAppLocalServiceUtil"%>
<%@page import="com.tamarack.liferay.payment.TempBankAccount"%>
<%@page import="com.liferay.util.*"%>
<%@page import="com.tamarack.liferay.payment.TempProposalOption"%>
<%@page import="com.tamarack.liferay.payment.TempPrincipal"%>
<%@page import="com.tamarack.creekridge.service.TermLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.PurchaseOptionLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.ProductLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.service.ProposalOptionLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.model.ProposalOption"%>
<%@page import="com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil"%>
<%@page import="com.tamarack.creekridge.model.CreditAppBankReference"%>
<%@page import="com.tamarack.creekridge.model.CreditApp"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.CompanyLocalServiceUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>

<portlet:defineObjects />

<%

	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

	long groupId = themeDisplay.getLayout().getGroupId();

    NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumFractionDigits(2);
    nf.setMinimumFractionDigits(2);

	System.out.println(" groupId:" + groupId);
	
	String webId = "liferay.com";
	long companyId = CompanyLocalServiceUtil.getCompanyByWebId(webId).getCompanyId();
	List<CreditApp> creditAppList=CreditAppLocalServiceUtil.getCreditApps(-1, -1);
	List<CreditAppStatus> creditAppStatusList=CreditAppStatusLocalServiceUtil.getCreditAppStatuses(-1, -1);
	boolean isOmniAdmin=themeDisplay.getPermissionChecker().isOmniadmin();
	boolean isGroupOwner = themeDisplay.getPermissionChecker().isGroupOwner(themeDisplay.getScopeGroupId());
	boolean isSiteMember =themeDisplay.getPermissionChecker().isGroupMember(themeDisplay.getScopeGroupId());
	boolean isCreekRidgeSalesManager=false;
	boolean isVendorSaleRep=false;
	User user = themeDisplay.getUser();
	if(isSiteMember) {
		List<com.liferay.portal.model.UserGroupRole> userGroupRoles = com.liferay.portal.service.UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId());
		List<com.liferay.portal.model.UserGroupRole> siteRoles = new ArrayList<com.liferay.portal.model.UserGroupRole>();
		
		for (com.liferay.portal.model.UserGroupRole userGroupRole : userGroupRoles) {
			int roleType = userGroupRole.getRole().getType();
			if (roleType == com.liferay.portal.model.RoleConstants.TYPE_SITE) {
	 			siteRoles.add(userGroupRole);
	 			System.out.println(" Custom Role "+userGroupRole.getRole().getName());
	 			if("salesManager".equalsIgnoreCase(userGroupRole.getRole().getName())){
		 			isCreekRidgeSalesManager=true;
					break;
				}
	 		}
		}

		if(!isCreekRidgeSalesManager) {
			for (com.liferay.portal.model.UserGroupRole userGroupRole : userGroupRoles) {
				int roleType = userGroupRole.getRole().getType();
					if (roleType == com.liferay.portal.model.RoleConstants.TYPE_SITE) {
		 			siteRoles.add(userGroupRole);
		 			System.out.println(" Custom Role "+userGroupRole.getRole().getName());
		 			if("salesRep".equalsIgnoreCase(userGroupRole.getRole().getName())){
						isVendorSaleRep=true;
						break;
			         }
		          }
		      }
	  	}
	} //end if sitemember
	
	
	Map<Long,String> statusMap= new HashMap<Long,String>();
	for (int j=0;j<creditAppStatusList.size();j++){
		statusMap.put(creditAppStatusList.get(j).getCreditAppStatusId(), creditAppStatusList.get(j).getCreditAppStatusName());
	}

	String salesRepNames = "";
	Map<String, String> usersMap= new HashMap<String,String>();

	for (int j=0;j<creditAppList.size();j++){
		String userName = creditAppList.get(j).getUserName();
		User user1 = UserLocalServiceUtil.getUserByScreenName(companyId, userName);

		String userFullName = user1.getLastName() + "," + user1.getFirstName();
		usersMap.put(userName, userFullName.toUpperCase());
	}
	
	Vector<String> userList = new Vector<String>();
	userList.addAll(usersMap.values());
	Collections.sort(userList);
	System.out.println("Users:" + userList);
	
	for (String userName1: userList){
		salesRepNames += "\"" +  userName1 + "\",";
	}

%>
<portlet:actionURL var="updateCreditAppUrl" >
  <portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="updateCreditApp" />
</portlet:actionURL>

<portlet:renderURL var="viewCreditApplicationUrl">
	<portlet:param name="jspPage" value="/web/vendor1/payment-calculator" />
</portlet:renderURL>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>

<style type="text/css" title="currentStyle">
    @import "<%=request.getContextPath()%>/css/viewCreditApp_page.css";
	@import "<%=request.getContextPath()%>/css/viewCreditApp_table.css";
	@import "http://jquery-datatables-column-filter.googlecode.com/svn/trunk/media/css/themes/base/jquery-ui.css";
	@import "http://jquery-datatables-column-filter.googlecode.com/svn/trunk/media/css/themes/smoothness/jquery-ui-1.7.2.custom.css";
	
	
	
	
	
	.displayFilterTemp {
		border: 1px solid black ;
	  	margin: 5px;
	  	padding: 5px;
	}
</style>
        
<script src="<%=request.getContextPath() %>/js/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.dataTables.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery-ui.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.dataTables.columnFilter.js" type="text/javascript"></script>


<script>
   $(document).ready(function () {
	   $.datepicker.regional[""].dateFormat = 'mm/dd/yy';
       $.datepicker.setDefaults($.datepicker.regional['']);
	   $('#creditAppView').DataTable()
	   .columnFilter({aoColumns:[
				{ type:"select", sSelector: "#creditApplicationStatus", values:["Saved","Submitted","Cancelled"], selected: 'Saved' },
				<%  if(!isVendorSaleRep)  {  %>								    
				{ type:"select", sSelector: "#salesRep", values:[<%=salesRepNames%>] },
				<% } %>
				{ type:"text", sSelector: "#customerName" },
			    { type:"date-range", sSelector: "#lastSavedDate" },
				{ type:"text", sSelector: "#appId" }
				]}
			);

		
	}); //end ready()


   function assignActionType(actionType, creditAppId) {
		
	   	document.<portlet:namespace />creditApp.<portlet:namespace />actionType.value = actionType;
	   	document.<portlet:namespace />creditApp.<portlet:namespace />creditAppId.value = creditAppId;
	   	document.<portlet:namespace />creditApp.submit();

	}

   function toggleImage(x) {
		if (x.className == "icon-circle-arrow-up") {
			x.className = "icon-circle-arrow-down";
		}	
		else {
			x.className = "icon-circle-arrow-up";			
		}
   }
</script>




<aui:row>
<h4 class="screenTitle">View Credit Applications</h4>
</aui:row>

<aui:row>
	<div class="span3">
		<a class="btn btn-info btn-block" href="payment-calculator"><i class="icon-pencil"></i> New Application</a>
	</div>
</aui:row>




<aui:form name="creditApp" action="<%=updateCreditAppUrl %>" method="post">
	<aui:input type="hidden" value="" name="creditAppId" />
	<aui:input type="hidden" value="" name="actionType" />

</aui:form>

<%-- 
<liferay-ui:search-container emptyResultsMessage="There are no applications to display" delta="1000">


    <liferay-ui:search-container-row
        className="com.tamarack.creekridge.model.CreditApp"
        keyProperty="creditAppId"
        modelVar="creditAppList" escapedModel="<%= false %>">
        
        <liferay-ui:search-container-column-text
            name="application-number"
            property="creditAppId"
        />

        <liferay-ui:search-container-column-text
            name="credit-app-status"
            property="creditAppStatusId"
        />


        <liferay-ui:search-container-column-text
            name="app-id"
            property="appId"
        />
        
        <liferay-ui:search-container-column-jsp
        path="/creditapplicationstable/appTableActions.jsp"
        align="right"
 		/>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />
</liferay-ui:search-container>
<<<<<<< HEAD

<div id="creditAppFilter">
<table  class="display" ID="main">
<tr><td>
<table style="width: 50px; background-color: lightgrey; border: 1px solid black ; margin: 5px;  padding: 5px;" class="display" ID="Table1">
			<thead>
			<th>
			<b>Filters</b>
			</th>
			</thead>
			<tbody style="width: 50px">
				<tr id="filter_global">
					<td align="center" style="width: 20px" ><b>Status:</b></td>
				</tr>
				<tr>
					<td align="center" style="width: 20px"  id="creditApplicationStatus"></td>
				</tr>
	<%  if(!isVendorSaleRep)  {  %>

				<tr id="filter_col3">
					<td align="center" style="width: 20px" ><b>Sales Rep:</b></td>
				</tr>
				<tr>
					<td align="center" style="width: 20px" id="salesRep"></td>
				</tr>				
	<% } %>
				<tr id="filter_col4">
					<td align="center" style="width: 20px" ><b>Customer Name:</b></td>
				 </tr>
				<tr>
					<td align="center" style="width: 20px"  id="customerName"></td>
				</tr>
				<tr id="filter_col2">
					<td align="center" style="width: 20px" ><b>Saved Date:</b></td>
				</tr>
				<tr>
					<td align="center" style="width: 20px" id="lastSavedDate"></td>
				</tr>

				<tr id="filter_col5">
					<td align="center" style="width: 20px" >Equipment Price:</td>
				</tr>
				<tr>
					<td align="center" style="width: 20px"  id="equipmentPrice"></td>
				</tr>

			</tbody>
		</table>
</td>
<td>		
 <table   id="creditAppView" class="display" >
 <thead>
    <tr>
			<th>Status</th>
	<%  if(!isVendorSaleRep)  {  %>
      
			<th>Sales Rep</th>
			   
	<%  }  %>
			<th>Customer Name</th>
			<th>Last Saved Date</th>
			<th>Equipment Price</th>
			<th>Action</th>
			<th></th>
			<th></th>
			<th></th>			
    </tr>
</thead>
<tfoot>

    <tr>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
    </tr>
</tfoot>

<tbody>

	<%  
	  String url = PortalUtil.getPathFriendlyURLPrivateGroup() + themeDisplay.getScopeGroup().getFriendlyURL();
	  System.out.println("url:" + url); 	
      for (int i=0;i<creditAppList.size();i++) {
  		String statusText = statusMap.get(creditAppList.get(i).getCreditAppStatusId());
       if( !"Cancelled1".equalsIgnoreCase(statusText) && !"Cancelled1".equalsIgnoreCase(statusText))
    	if((isVendorSaleRep && creditAppList.get(i).getUserId() == themeDisplay.getUserId()) || (isCreekRidgeSalesManager  && (creditAppList.get(i).getGroupId() == groupId)) || isOmniAdmin )  {
    		DateFormat fmt = new SimpleDateFormat("MM/dd/YYYY");
    		String modDate = fmt.format(creditAppList.get(i).getModifiedDate());  		
      %>

		<tr>
			<td> <%=statusMap.get(creditAppList.get(i).getCreditAppStatusId())%>
			</td>	      

			<td><%=modDate%>

			</td>

	<%  if(!isVendorSaleRep)  {  %>
			<td ><%=usersMap.get(creditAppList.get(i).getUserName())%>
			</td>      
	<%  }  %>			
			<td><%=creditAppList.get(i).getCustomerName()%>
			</td>
			<td> <%=creditAppList.get(i).getEquipmentPrice()%>
			</td>
	

			<%if( "Draft".equalsIgnoreCase(statusText)){ %>
			 <td><button  type="button"  name="view" value="View" onclick="<%="javascript:window.location.href='" + url + "/payment-calculator?viewOnly=true&creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-search">View</i></button></td>
		     <td><button  type="button"  name="edit" value="Edit" onclick="<%="javascript:window.location.href='" + url + "/payment-calculator?creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-pencil">Edit</i></button></td>
		     <td><button  type="button"  name="manage" value="Manage Docs" onclick="<%="javascript:window.location.href='" + url + "/payment-calculator?creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-file">Docs</i></button></td>
		     <td><button  type="button"  name="cancel"  value="Cancel" onclick="javascript:assignActionType('cancel','<%=creditAppList.get(i).getCreditAppId() %>')" ><i class="icon-trash">Delete</i></button></td>
	          <%} %>			
			<%if( "Saved".equalsIgnoreCase(statusText)){ %>
			 <td><button  type="button"  name="view" value="View" onclick="<%="javascript:window.location.href='" + url + "/payment-calculator?viewOnly=true&creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-search">View</i></button></td>
		     <td><button  type="button"  name="edit" value="Edit" onclick="<%="javascript:window.location.href='" + url + "/payment-calculator?creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-pencil">Edit</i></button></td>
		     <td><button  type="button"  name="manage" value="Manage Docs" onclick="<%="javascript:window.location.href='" + url + "/payment-calculator?creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-file">Docs</i></button></td>
		     <td><button  type="button"  name="cancel"  value="Cancel" onclick="javascript:assignActionType('cancel','<%=creditAppList.get(i).getCreditAppId() %>')" ><i class="icon-trash">Delete</i></button></td>
	          <%} %>
			<%if( "Submitted".equalsIgnoreCase(statusText)){ %>
			 <td><button  type="button"  name="view" value="View" onclick="<%="javascript:window.location.href='" + url + "/payment-calculator?viewOnly=true&creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-search">View</i></button></td>
		     <td><button  type="button"  name="manage" value="Manage Docs" onclick="<%="javascript:window.location.href='" + url + "/payment-calculator?creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-file">Docs</i></button></td>
		     <td></td>
		     <td></td>
	          <%} %>	          
			<%if( "Cancelled".equalsIgnoreCase(statusText)){ %>
			 <td><button  type="button"  name="view" value="View" onclick="<%="javascript:window.location.href='" + url + "/payment-calculator?viewOnly=true&creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-search">View</i></button></td>
		     <td><button  type="button"  name="reenable" value="Re-enable" onclick="<%="javascript:window.location.href='" + url + "/payment-calculator?creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-refresh">Re-enable</i></button></td>
		     <td></td>
		     <td></td>
		     <%} %>
		     

		</tr>
	<%} 
	}%>
	</tbody>
	</table>
</td>
</tr>
</table>
</div>
<div class="spacer"></div>

>>>>>>> master
</html>
=======
 --%>

<aui:row>
	<aui:col span="4">
		<div class="filterSection">
			<h4>Filters:</h4>
			<dl>
			  <dt>Status:</dt><dd id="creditApplicationStatus"></dd>
			  <%  if(!isVendorSaleRep)  {  %>
			  	<dt>Sales Rep:</dt><dd id="salesRep"></dd>
			  <% } %>
			  <dt>Customer Name:</dt><dd id="customerName"></dd>
			  <dt>Last Saved:</dt><dd id="lastSavedDate"></dd>
			  <dt>App #:</dt><dd id="appId"></dd>
			</dl>
		</div>
	</aui:col>
	<aui:col span="8">
		<div id="viewApplications">
			<table id="creditAppView" class="table table-responsive table-striped table-hover" data-toggle="table">
			 	<thead>
			    	<tr>
						<th><i onclick="toggleImage(this)" class="icon-circle-arrow-up"> Status</i></th>
						
						<%  if(!isVendorSaleRep)  {  %>
						<th><i onclick="toggleImage(this)" class="icon-circle-arrow-up"> Sales Rep</i></th>		   
						<%  }  %>
						
						<th><i onclick="toggleImage(this)" class="icon-circle-arrow-up"> Customer Name</i></th>
						<th><i onclick="toggleImage(this)" class="icon-circle-arrow-up"> Last Saved Date</i></th>
						<th><i onclick="toggleImage(this)" class="icon-circle-arrow-up"> App Id</i></th>
						<th><i onclick="toggleImage(this)" class="icon-circle-arrow-up"> Equipment Price</i></th>
						<th>Action</th>	
			    	</tr>
				</thead>
				<tfoot>
				    <tr>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<%  
							if(!isVendorSaleRep)  { 
						%>      
						<th></th>
						<%  
							}
						%>
				    </tr>
				</tfoot>
			
				<tbody>
				
					<%  
					String url = PortalUtil.getPathFriendlyURLPrivateGroup() + themeDisplay.getScopeGroup().getFriendlyURL();
					  	
					System.out.println("url:" + url); 	
				    for (int i=0;i<creditAppList.size();i++) {
				  		String statusText = statusMap.get(creditAppList.get(i).getCreditAppStatusId());
				       	
				  		if( !"Cancelled1".equalsIgnoreCase(statusText) && !"Cancelled1".equalsIgnoreCase(statusText))
						
				  			if(isSiteMember && (creditAppList.get(i).getVendorId() == groupId))
				    	
				  				if((isVendorSaleRep && (creditAppList.get(i).getUserId() == themeDisplay.getUserId())) || !isVendorSaleRep)  {
				    			DateFormat fmt = new SimpleDateFormat("MM/dd/YYYY");
				    			String modDate = fmt.format(creditAppList.get(i).getModifiedDate());  		
				      %>
				
						<tr>
							<td> <%=statusMap.get(creditAppList.get(i).getCreditAppStatusId())%>
							</td>	      
				
				
				
					<%  if(!isVendorSaleRep)  {  %>
							<td ><%=usersMap.get(creditAppList.get(i).getUserName())%>
							</td>      
					<%  }  %>			
							<td><%=creditAppList.get(i).getCustomerName()%></td>
							<td><%=modDate%></td>
							<td> <%=creditAppList.get(i).getCreditAppId()%></td>
							<td> $<%=nf.format(creditAppList.get(i).getEquipmentPrice())%></td>	
				
							<td class="col-md-3">
							<%if( "Draft".equalsIgnoreCase(statusText)){ %>
							 <a   name="View" value="View"  href="<%="javascript:window.location.href='" + url + "/payment-calculator?viewOnly=true&creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-search"></i> View</a>|
						     <a name="edit" value="Edit" href="<%="javascript:window.location.href='" + url + "/payment-calculator?creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-pencil"></i> Edit</a>|
						     <a  name="manage" value="Manage Docs" href="<%="javascript:window.location.href='" + url + "/manage-documents?creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-file"></i> Docs</a>|
						     <a  name="cancel"  value="Cancel" href="javascript:assignActionType('cancel','<%=creditAppList.get(i).getCreditAppId() %>')" ><i class="icon-trash"></i> Cancel</a>
					          <%} %>	
					          		
							<%if( "Saved".equalsIgnoreCase(statusText)){ %>
							 <a  name="view" value="View" href="<%="javascript:window.location.href='" + url + "/payment-calculator?viewOnly=true&creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-search"> View</i></a> |
						     <a  name="edit" value="Edit" href="<%="javascript:window.location.href='" + url + "/payment-calculator?creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-pencil"> Edit</i></a> |
						     <a  name="manage" value="Manage Docs" href="<%="javascript:window.location.href='" + url + "/manage-documents?creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-file"> Docs</i></a> |
						     <a  name="cancel"  value="Cancel" href="javascript:assignActionType('cancel','<%=creditAppList.get(i).getCreditAppId() %>')" ><i class="icon-trash"> Cancel</i></a> 
					          <%} %>
							<%if( "Submitted".equalsIgnoreCase(statusText)){ %>
							 <a  name="view" value="View" href="<%="javascript:window.location.href='" + url + "/payment-calculator?viewOnly=true&creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-search"> View</i></a> |
						     <a  name="manage" value="Manage Docs" href="<%="javascript:window.location.href='" + url + "/manage-documents?creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-file"> Docs</i></a> 
					          <%} %>	          
							<%if( "Cancelled".equalsIgnoreCase(statusText)){ %>
							 <a  name="view" value="View" href="<%="javascript:window.location.href='" + url + "/payment-calculator?viewOnly=true&creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-search"></i> View</a> |
						     <a  name="reenable" value="Re-enable" href="<%="javascript:window.location.href='" + url + "/payment-calculator?creditAppId="+creditAppList.get(i).getCreditAppId() +"'" %>" ><i class="icon-refresh"></i> Re-Enable</a> 
						     <%} %>		     
							</td>
						</tr>
					<%} 
					}%>
				</tbody>
			</table>
		</div>
	</aui:col>
</aui:row>	
>>>>>>> master
