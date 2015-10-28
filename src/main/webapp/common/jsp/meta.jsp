    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- HTTP 1.1 -->
    <meta http-equiv="Cache-Control" content="no-store"/>
    <!-- HTTP 1.0 -->
    <meta http-equiv="Pragma" content="no-cache"/>
    <!-- Prevents caching at the Proxy Server -->
    <meta http-equiv="Expires" content="0"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="icon" href="${ctx }/favicon.ico" mce_href="${ctx }/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="${ctx }/favicon.ico" mce_href="${ctx }/favicon.ico" type="image/x-icon"> 
    <link href="${ctx}/plugin/metronic/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

	<link href="${ctx}/plugin/metronic/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

	<link href="${ctx}/plugin/metronic/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

	<link href="${ctx}/plugin/metronic/css/style-metro.css" rel="stylesheet" type="text/css"/>

	<link href="${ctx}/plugin/metronic/css/style.css" rel="stylesheet" type="text/css"/>

	<link href="${ctx}/plugin/metronic/css/style-responsive.css" rel="stylesheet" type="text/css"/>

	<link href="${ctx}/plugin/metronic/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

	<link href="${ctx}/plugin/metronic/css/uniform.default.css" rel="stylesheet" type="text/css"/>

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES --> 

	<link href="${ctx}/plugin/metronic/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>

	<link href="${ctx}/plugin/metronic/css/daterangepicker.css" rel="stylesheet" type="text/css" />

	<link href="${ctx}/plugin/metronic/css/fullcalendar.css" rel="stylesheet" type="text/css"/>

	<link href="${ctx}/plugin/metronic/css/jqvmap.css" rel="stylesheet" type="text/css" ${ctx}/plugin/metronic="screen"/>

	<link href="${ctx}/plugin/metronic/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" ${ctx}/plugin/metronic="screen"/>

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="${ctx}/plugin/metronic/image/favicon.ico" />

	<!-- 分页样式 -->
	<link rel="stylesheet" type="text/css" href="${ctx}/common/css/back_pageUtil.css" />
	
    <script src="${ctx}/plugin/metronic/js/jquery-1.10.1.min.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="${ctx}/plugin/metronic/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      

	<script src="${ctx}/plugin/metronic/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="${ctx}/plugin/metronic/js/excanvas.min.js"></script>

	<script src="${ctx}/plugin/metronic/js/respond.min.js"></script>  

	<![endif]-->   

	<script src="${ctx}/plugin/metronic/js/jquery.slimscroll.min.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/jquery.blockui.min.js" type="text/javascript"></script>  

	<script src="${ctx}/plugin/metronic/js/jquery.cookie.min.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/jquery.uniform.min.js" type="text/javascript" ></script>

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="${ctx}/plugin/metronic/js/jquery.vmap.js" type="text/javascript"></script>   

	<script src="${ctx}/plugin/metronic/js/jquery.vmap.russia.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/jquery.vmap.world.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/jquery.vmap.europe.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/jquery.vmap.germany.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/jquery.vmap.usa.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/jquery.vmap.sampledata.js" type="text/javascript"></script>  

	<script src="${ctx}/plugin/metronic/js/jquery.flot.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/jquery.flot.resize.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/jquery.pulsate.min.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/date.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/daterangepicker.js" type="text/javascript"></script>     

	<script src="${ctx}/plugin/metronic/js/jquery.gritter.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/fullcalendar.min.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/jquery.easy-pie-chart.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/jquery.sparkline.min.js" type="text/javascript"></script>  

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${ctx}/plugin/metronic/js/app.js" type="text/javascript"></script>

	<script src="${ctx}/plugin/metronic/js/index.js" type="text/javascript"></script>        

	<!-- END PAGE LEVEL SCRIPTS -->  

	<script>

		jQuery(document).ready(function() {    

		   App.init(); // initlayout and core plugins

		   Index.init();

		   Index.initJQVMAP(); // init index page's custom scripts

		   Index.initCalendar(); // init index page's custom scripts

		   Index.initCharts(); // init index page's custom scripts

		   Index.initChat();

		   Index.initMiniCharts();

		   Index.initDashboardDaterange();

		   Index.initIntro();

		});
	</script>
	<script type="text/javascript">  
		var _gaq = _gaq || []; 
		_gaq.push(['_setAccount', 'UA-37564768-1']);  
		_gaq.push(['_setDomainName', 'keenthemes.com']); 
		_gaq.push(['_setAllowLinker', true]);  
		_gaq.push(['_trackPageview']);  
		(function() {    
			var ga = document.createElement('script'); 
			ga.type = 'text/javascript'; 
			ga.async = true;    
			ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    
			var s = document.getElementsByTagName('script')[0]; 
			s.parentNode.insertBefore(ga, s);  
			}
		)();
	</script>
        
    <script type="text/javascript">
		var ctx="${ctx}"; 
	</script>