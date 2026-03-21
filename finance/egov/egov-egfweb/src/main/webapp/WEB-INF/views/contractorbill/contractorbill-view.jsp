<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tags/cdn.tld" prefix="cdn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<style type="text/css">
@media print {
    #printButton       { display: none !important; }
    #closeButton       { display: none !important; }
    header             { display: none !important; }
    footer             { display: none !important; }
    nav                { display: none !important; }
    .navbar            { display: none !important; }
    .navbar-header     { display: none !important; }
    .sidebar           { display: none !important; }
    .left-panel        { display: none !important; }
    .commontopyellowbg { display: none !important; }
    .commontopbluebg   { display: none !important; }
    .commontopbg       { display: none !important; }
    .commonbottombg    { display: none !important; }
    .footerfix         { display: none !important; }
    .nav-tabs          { display: none !important; }
    .position_alert    { display: none !important; }
    .position_alert1   { display: none !important; }
    .position_alert2   { display: none !important; }
    @page { margin: 0; }
    body  { margin: 1cm; }
}
</style>

<form:form name="contractorBillForm" role="form" action="" modelAttribute="egBillregister" id="egBillregister"
           class="form-horizontal form-groups-bordered" enctype="multipart/form-data">
    <div>
        <spring:hasBindErrors name="egBillregister">
            <div class="alert alert-danger col-md-10 col-md-offset-1">
                <form:errors path="*"/><br/>
            </div>
        </spring:hasBindErrors>
    </div>
    <input type="hidden" id="id" value="${egBillregister.id }"/>
    <input type="hidden" name="mode" id="mode" value="${mode }"/>
    <input type="hidden" name="budgetDetails" id="budgetDetails" value="${budgetDetails}" />
    <%--<form:hidden path="budgetDetails" id="budgetDetails" class="budgetDetail" value="${budgetDetails}"/>--%>
    <form:hidden path="billamount" id="billamount" class="billamount" value="${egBillregister.billamount }"/>
    <form:hidden path="" name="netPayableAmount" id="netPayableAmount" value="${netPayableAmount}"/>
    <div class="panel-title text-center" style="color: green;">
        <c:out value="${message}"/><br/>
    </div>

        <jsp:include page="contractorbill-view-header.jsp"/>
        <jsp:include page="contractorbill-view-accountdetails.jsp"/>
        <jsp:include page="contractorbill-view-subledgeraccountdetails.jsp"/>
        <c:if test="${egBillregister.documentDetail != null &&  !egBillregister.documentDetail.isEmpty()}">
            <jsp:include page="billdocument-upload.jsp"/>
        </c:if>
        <%-- <jsp:include page="contractorbill-budgetdetails.jsp"/> --%>
        <c:if test="${!workflowHistory.isEmpty() && mode != 'readOnly'}">
            <jsp:include page="../common/commonworkflowhistory-view.jsp"></jsp:include>
        </c:if>
        <c:if test="${mode != 'readOnly'}">
            <jsp:include page="../common/commonworkflowmatrix.jsp"/>
            <div class="buttonbottom" align="center">
                <jsp:include page="../common/commonworkflowmatrix-button.jsp"/>
            </div>
        </c:if>
        <c:if test="${mode == 'readOnly'}">
            <div class="row">
                <div class="col-sm-12 text-center">
                    <input type="button" name="printButton" id="printButton"
						value='<spring:message code="lbl.print" text="Print"/>'
						class="btn btn-primary" style="margin-right: 10px;"
						onclick="window.print();" /> 
						
					<input type="submit"
						name="closeButton" id="closeButton"
						value='<spring:message code="lbl.close" text="Close"/>'
						class="btn btn-default" onclick="window.close();" />
                </div>
            </div>
        </c:if>

</form:form>
<script src="<cdn:url value='/resources/app/js/contractorbill/viewcontractorbill.js?rnd=${app_release_no}'/>"></script>
<script src="<cdn:url value='/resources/global/js/egov/patternvalidation.js?rnd=${app_release_no}' context='/services/egi'/>"></script>
<script src="<cdn:url value='/resources/global/js/egov/inbox.js?rnd=${app_release_no}' context='/services/egi'/>"></script>
