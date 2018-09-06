<%@page import="java.util.ArrayList"%>
<%@page import="Model.cart"%>
<%@page import="Model.user"%>
<%@page import="Database.query"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Bootshop online Shopping cart</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!--Less styles -->
        <!-- Other Less css file //different less files has different color scheam
             <link rel="stylesheet/less" type="text/css" href="themes/less/simplex.less">
             <link rel="stylesheet/less" type="text/css" href="themes/less/classified.less">
             <link rel="stylesheet/less" type="text/css" href="themes/less/amelia.less">  MOVE DOWN TO activate
        -->
        <!--<link rel="stylesheet/less" type="text/css" href="themes/less/bootshop.less">
        <script src="themes/js/less.js" type="text/javascript"></script> -->

        <!-- Bootstrap style --> 
        <link id="callCss" rel="stylesheet" href="themes/bootshop/bootstrap.min.css" media="screen"/>
        <link href="themes/css/base.css" rel="stylesheet" media="screen"/>
        <!-- Bootstrap style responsive -->	
        <link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet"/>
        <link href="themes/css/font-awesome.css" rel="stylesheet" type="text/css">
        <!-- Google-code-prettify -->	
        <link href="themes/js/google-code-prettify/prettify.css" rel="stylesheet"/>
        <!-- fav and touch icons -->
        <link rel="shortcut icon" href="themes/images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="themes/images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="themes/images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="themes/images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="themes/images/ico/apple-touch-icon-57-precomposed.png">
        <style type="text/css" id="enject"></style>

          <%!
            String msg = "";
            String name = "";
            String price = "";
            String quntity = "";
            String model = "";
            String size = "";
            String features = "";
            String color = "";
            String image = "";
            int item = 0;
            double total_price = 0.0;
        %>
        <%
            
            query db=new query();
        msg=(String)request.getAttribute("msg");
        if(msg=="0"){
           name=(String)request.getAttribute("name"); 
           price=(String)request.getAttribute("price"); 
           quntity=(String)request.getAttribute("Quantity"); 
           model=(String)request.getAttribute("model"); 
           size=(String)request.getAttribute("size"); 
           color=(String)request.getAttribute("color"); 
           features=(String)request.getAttribute("features"); 
           image=(String)request.getAttribute("image"); 
        msg="Product Not added...try again!";
        }else{
        msg="";
        }
          cart c = new cart();
            ArrayList<cart> car = new ArrayList<>();
            car = c.getIdcart();
            item = 0;
            total_price = 0.0;
            for (int i = 0; i < car.size(); i++) {
                item += car.get(i).getQuantity();
                total_price += (car.get(i).getPrice() * car.get(i).getQuantity());

            }
       
        %>
        
        
    </head>
    <body>
        <div id="header">
            <div class="container">
                <div id="welcomeLine" class="row">
                    <div class="span6">Welcome!<strong> User</strong></div>
                    <div class="span6">
                        <div class="pull-right">
                            <span class="btn btn-mini">$<%=total_price%></span>
                            <a href="product_summary.jsp"><span class="btn btn-mini btn-primary"><i class="icon-shopping-cart icon-white"></i> [  <%=item%> ] Items in your cart </span> </a> 
                        </div>
                    </div>
                </div>
                <!-- Navbar ================================================== -->
                <div id="logoArea" class="navbar">
                    <a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <div class="navbar-inner">
                        <a class="brand" href="index.jsp"><img src="themes/images/logo.png" alt="Bootsshop"/></a>
                         <form class="form-inline navbar-search" method="post" action="search.jsp" >
        <input id="srchFld" class="srchTxt" type="text" name="key" value="" style="padding-left: 30px"/>
                <select class="srchTxt" name="search">
                    <option value="0">All</option>
                    <option value="1"> ELECTRONICS </option>
                    <option value="2">CLOTHES </option>
                    <option value="3">FOOD AND BEVERAGES </option>
                    <option value="4">SPORTS & LEISURE </option>
                    <option value="5">BOOKS & ENTERTAINMENTS </option>
                    <option value="6">OTHERS </option>
		</select> 
		  <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
    </form>
                        <ul id="topMenu" class="nav pull-right">
   <li class=""><a href="products.jsp">Products</a></li>
	 <li class=""><a href="contact.jsp">Contact</a></li>
	 <li class=""><a href="profile.jsp">profile</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- Header End====================================================================== -->
        <div id="mainBody">
            <div class="container">
                <div class="row">
                    <!-- Sidebar ================================================== -->
                    <div id="sidebar" class="span3">
                        <div class="well well-small"><a id="myCart" href="product_summary.jsp"><img src="themes/images/ico-cart.png" alt="cart"> <%=item%> Items in your cart  <span class="badge badge-warning pull-right">$<%=total_price%></span></a></div>
                      <ul id="sideManu" class="nav nav-tabs nav-stacked">
			
			<li><a href="products.jsp?product_id=1">ELECTRONICS [<%=db.count(1)%>]</a></li>
			<li><a href="products.jsp?product_id=2">CLOTHES [<%=db.count(2)%>]</a></li>
			<li><a href="products.jsp?product_id=3">SPORTS & LEISURE [<%=db.count(3)%>]</a></li>
			<li><a href="products.jsp?product_id=4">BOOKS & ENTERTAINMENTS [<%=db.count(4)%>]</a></li>
			<li><a href="products.jsp?product_id=5">FOOD[<%=db.count(5)%>]</a></li>
			<li><a href="products.jsp?product_id=6">OTHERS[<%=db.count(6)%>]</a></li>
		</ul>
                        <br/>
                        
                       <br/>
                        <div class="thumbnail">
                            <img src="themes/images/payment_methods.png" title="Bootshop Payment Methods" alt="Payments Methods">
                            <div class="caption">
                                <h5>Payment Methods</h5>
                            </div>
                        </div>
                    </div> 
                    <!-- Sidebar end=============================================== -->
                    <div class="span9">
                        <ul class="breadcrumb">
                            <li><a href="index.jsp">Home</a> <span class="divider">/</span></li>
                            <li class="active">Add Product</li>
                        </ul>
                        <h3> New Product</h3>	
                        <div class="well">
                            <!--
                            <div class="alert alert-info fade in">
                                    <button type="button" class="close" data-dismiss="alert">×</button>
                                    <strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
                             </div>
                            <div class="alert fade in">
                                    <button type="button" class="close" data-dismiss="alert">×</button>
                                    <strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
                             </div>
                             <div class="alert alert-block alert-error fade in">
                                    <button type="button" class="close" data-dismiss="alert">×</button>
                                    <strong>Lorem Ipsum is simply</strong> dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
                             </div> -->
                            <form class="form-horizontal" method="post" action="add_product" enctype="multipart/form-data">
                                <h4>Product information</h4>
                                <div class="control-group">
                                    <label class="control-label"> <sup></sup></label>

                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="inputFname1">product name <sup style="color: red">*</sup></label>
                                    <div class="controls">
                                        <input type="text" id="inputFname1" placeholder="product Name" name="name" value="<%=name%>" required="required">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="inputLnam">price <sup style="color: red">*</sup></label>
                                    <div class="controls">
                                        <input type="number" id="inputLnam" placeholder="price" name="price" value="<%=price%>" required="required">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="input_email">Quantity <sup style="color: red">*</sup></label>
                                    <div class="controls">
                                        <input type="number" id="input_email" placeholder="Quantity" name="Quantity" value="<%=quntity%>" required="required">
                                    </div>
                                </div>	  
                                <div class="control-group">
                                    <label class="control-label" for="inputPassword1">model <sup style="color: red">*</sup></label>
                                    <div class="controls">
                                        <input type="text" id="inputPassword1" placeholder="model" name="model" value="<%=model%>" required="required">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="inputPassword1">color <sup style="color: red">*</sup></label>
                                    <div class="controls">
                                        <input type="text" id="inputPassword1" placeholder="color" name="color" value="<%=color%>" required="required"> if there are many color write them as (red,green,...)
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">part <sup style="color: red">*</sup></label>
                                    <div class="controls">
                                        <select class="span1" name="part" style="width: 110px" >
                                            <option value="Electronics">Electronics&nbsp;&nbsp;</option>
                                            <option value="Clothes">Clothes&nbsp;&nbsp;</option>
                                            <option value="Sport">Sport&nbsp;&nbsp;</option>
                                            <option value="Books">Books&nbsp;&nbsp;</option>
                                            <option value="Food">Food&nbsp;&nbsp;</option>
                                            <option value="Other">Other&nbsp;&nbsp;</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="size">size<sup style="color: red">*</sup></label>
                                    <div class="controls">
                                        <input type="text" id="address" placeholder="size" name="size" value="<%=size%>" required="required"required="required"/> 
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="features">features<sup style="color: red">*</sup></label>
                                    <div class="controls">
                                        <textarea placeholder="features" name="features" style="height: 100px" required="required"><%=features%></textarea>
                                    </div>
                                </div>
                                
                                <div class="control-group">
                                    <label class="control-label" for="image">image<sup style="color: red">*</sup></label>
                                    <div class="controls">
                                        <input type="file" name="nimage"  class="form-control" id="un" placeholder="product Image" value="<%=image%>" required="required"/>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="controls">
                                        <input type="hidden" name="email_create" value="1">
                                        <input type="hidden" name="is_new_customer" value="1">
                                        <label style="color: red;font-size: 18px"><%=msg%></label>
                                        <input class="btn btn-large btn-success" type="submit" value="Add Product" />
                                    </div>
                                </div>		
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- MainBody End ============================= -->
        <!-- Footer ================================================================== -->
        <div  id="footerSection">
            <div class="container">
                <div class="row">
                    <div class="span3">
                        <h5>ACCOUNT</h5>
                        <a href="login.jsp">YOUR ACCOUNT</a>
                        <a href="login.jsp">PERSONAL INFORMATION</a> 
                        <a href="login.jsp">ADDRESSES</a> 
                        <a href="login.jsp">DISCOUNT</a>  
                        <a href="login.jsp">ORDER HISTORY</a>
                    </div>
                    <div class="span3">
                        <h5>INFORMATION</h5>
                        <a href="contact.jsp">CONTACT</a>  
                        <a href="register.jsp">REGISTRATION</a>  
                        <a href="legal_notice.jsp">LEGAL NOTICE</a>  
                        <a href="tac.jsp">TERMS AND CONDITIONS</a> 
                        <a href="faq.jsp">FAQ</a>
                    </div>
                    <div class="span3">
                        <h5>OUR OFFERS</h5>
                        <a href="#">NEW PRODUCTS</a> 
                        <a href="#">TOP SELLERS</a>  
                        <a href="special_offer.jsp">SPECIAL OFFERS</a>  
                        <a href="#">MANUFACTURERS</a> 
                        <a href="#">SUPPLIERS</a> 
                    </div>
                    <div id="socialMedia" class="span3 pull-right">
                        <h5>SOCIAL MEDIA </h5>
                        <a href="#"><img width="60" height="60" src="themes/images/facebook.png" title="facebook" alt="facebook"/></a>
                        <a href="#"><img width="60" height="60" src="themes/images/twitter.png" title="twitter" alt="twitter"/></a>
                        <a href="#"><img width="60" height="60" src="themes/images/youtube.png" title="youtube" alt="youtube"/></a>
                    </div> 
                </div>
                <p class="pull-right">&copy; Bootshop</p>
            </div><!-- Container End -->
        </div>
        <!-- Placed at the end of the document so the pages load faster ============================================= -->
        <script src="themes/js/jquery.js" type="text/javascript"></script>
        <script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="themes/js/google-code-prettify/prettify.js"></script>

        <script src="themes/js/bootshop.js"></script>
        <script src="themes/js/jquery.lightbox-0.5.js"></script>

        <!-- Themes switcher section ============================================================================================= -->
        <div id="secectionBox">
            <link rel="stylesheet" href="themes/switch/themeswitch.css" type="text/css" media="screen" />
            <script src="themes/switch/theamswitcher.js" type="text/javascript" charset="utf-8"></script>
            <div id="themeContainer">
                <div id="hideme" class="themeTitle">Style Selector</div>
                <div class="themeName">Oregional Skin</div>
                <div class="images style">
                    <a href="themes/css/#" name="bootshop"><img src="themes/switch/images/clr/bootshop.png" alt="bootstrap business templates" class="active"></a>
                    <a href="themes/css/#" name="businessltd"><img src="themes/switch/images/clr/businessltd.png" alt="bootstrap business templates" class="active"></a>
                </div>
                <div class="themeName">Bootswatch Skins (11)</div>
                <div class="images style">
                    <a href="themes/css/#" name="amelia" title="Amelia"><img src="themes/switch/images/clr/amelia.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="spruce" title="Spruce"><img src="themes/switch/images/clr/spruce.png" alt="bootstrap business templates" ></a>
                    <a href="themes/css/#" name="superhero" title="Superhero"><img src="themes/switch/images/clr/superhero.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="cyborg"><img src="themes/switch/images/clr/cyborg.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="cerulean"><img src="themes/switch/images/clr/cerulean.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="journal"><img src="themes/switch/images/clr/journal.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="readable"><img src="themes/switch/images/clr/readable.png" alt="bootstrap business templates"></a>	
                    <a href="themes/css/#" name="simplex"><img src="themes/switch/images/clr/simplex.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="slate"><img src="themes/switch/images/clr/slate.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="spacelab"><img src="themes/switch/images/clr/spacelab.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="united"><img src="themes/switch/images/clr/united.png" alt="bootstrap business templates"></a>
                    <p style="margin:0;line-height:normal;margin-left:-10px;display:none;"><small>These are just examples and you can build your own color scheme in the backend.</small></p>
                </div>
                <div class="themeName">Background Patterns </div>
                <div class="images patterns">
                    <a href="themes/css/#" name="pattern1"><img src="themes/switch/images/pattern/pattern1.png" alt="bootstrap business templates" class="active"></a>
                    <a href="themes/css/#" name="pattern2"><img src="themes/switch/images/pattern/pattern2.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern3"><img src="themes/switch/images/pattern/pattern3.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern4"><img src="themes/switch/images/pattern/pattern4.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern5"><img src="themes/switch/images/pattern/pattern5.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern6"><img src="themes/switch/images/pattern/pattern6.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern7"><img src="themes/switch/images/pattern/pattern7.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern8"><img src="themes/switch/images/pattern/pattern8.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern9"><img src="themes/switch/images/pattern/pattern9.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern10"><img src="themes/switch/images/pattern/pattern10.png" alt="bootstrap business templates"></a>

                    <a href="themes/css/#" name="pattern11"><img src="themes/switch/images/pattern/pattern11.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern12"><img src="themes/switch/images/pattern/pattern12.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern13"><img src="themes/switch/images/pattern/pattern13.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern14"><img src="themes/switch/images/pattern/pattern14.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern15"><img src="themes/switch/images/pattern/pattern15.png" alt="bootstrap business templates"></a>

                    <a href="themes/css/#" name="pattern16"><img src="themes/switch/images/pattern/pattern16.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern17"><img src="themes/switch/images/pattern/pattern17.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern18"><img src="themes/switch/images/pattern/pattern18.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern19"><img src="themes/switch/images/pattern/pattern19.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern20"><img src="themes/switch/images/pattern/pattern20.png" alt="bootstrap business templates"></a>

                </div>
            </div>
        </div>
        <span id="themesBtn"></span>
    </body>
    
</html>