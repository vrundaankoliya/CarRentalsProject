<!DOCTYPE html>



<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
        <link rel="stylesheet" href="css/custom.css" type="text/css" />
     <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="http://localhost:8080/login/js/bootstrap.min.js"></script>
<title>Rental Services</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="http://localhost:8080/login/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://localhost:8080/login/css/bootstrap-theme.min.css"
	type="text/css" />
<link rel="stylesheet" href="http://localhost:8080/login/css/footer.css" type="text/css" />
               
        <script>
            
            
  var dateToday = new Date(); 
var tomorrow = new Date();
tomorrow.setDate(tomorrow.getDate() + 1);
    $(function() {
        $( "#startDate" ).datepicker({
            showButtonPanel: true,
            minDate: dateToday
        });
    });
    
    $(function() {
        $( "#endDate" ).datepicker({
            showButtonPanel: true,
            beforeShow: function() {
                $(this).datepicker('option', 'minDate', $('#startDate').val());
                if ($('#startDate').val() ==='') 
                    $(this).datepicker('option', 'minDate', 0); 
                if ($('#startDate').val() === dateToday) 
                    $(this).datepicker('option', 'minDate', tomorrow);  
             }
        });
    });
    $(document).ready(function(){
        
		$("#sub").hide();
		$("#op").hide();
        $('#orderForm')[0].reset();
        $("#totalCost").hide();
        $(".compact").hide();
        $(".midSize").hide();
        $(".luxury").hide();
        $('#startDate').datepicker().bind("change", function () {
            calculate();
        });
        $('#endDate').datepicker().bind("change", function () {
            calculate();
        });

        function calculate() {
            var d1 = $('#startDate').datepicker('getDate');
            var d2 = $('#endDate').datepicker('getDate');
            var oneDay = 24*60*60*1000;
            var diff = 0;
            if (d1 && d2) {
          
              diff = Math.round(Math.abs((d2.getTime() - d1.getTime())/(oneDay)));
            }
            $('.minim').val(diff);
        }
        $("#submit").click(function(){
        //  event.preventDefault();
            $("#error").text("");
			
          var total=0;
          var insurance=0;
          var iCompact= $('input[name="iCompact"]:checked').val();
          var iMidSize= $('input[name="iMidSize"]:checked').val();
          var iLuxury= $('input[name="iLuxury"]:checked').val();
         var costOfType= $("#cars option:selected").val();
         var giftcard= $('input[name="giftcard"]:checked').val();
         var carWash= $('input[name="giftcard"]:checked').val();
         if(typeof(iCompact)!=='undefined'){
           // alert("iCompact="+iCompact);
            insurance=  iCompact;
         }else if(typeof(iMidSize)!=='undefined'){
             // alert("iMidSize="+iMidSize);
              insurance=  iMidSize; 
          }else if(typeof(iLuxury)!== 'undefined' ){
                //alert("iLuxury="+iLuxury);
          
             insurance=   iLuxury;
          }
          total=Number(costOfType,2)+Number(insurance,2);
          if ($('#startDate').val() === '') {
               $("#error").text("Please select correct Start date");
             //  alert("<15");
            return false;
          }
           if ($('#startDate').val() === '') {
               $("#error").text("Please select correct Start date");
            return false;
          }
           
        var totalDays=Number($('.minim').val());
        
        if(totalDays===0){
             $("#error").text("Please select correct end date");
            return false;
        }
        if(totalDays<=15){
           total=total*totalDays;
          // alert("<15");
        }
        else if(totalDays>15 && totalDays<30){
            total=total*totalDays*90/100;
           // alert("<15 and <30");
        }else if(totalDays>=30){
             total=total*totalDays*85/100;
            // alert(">30");
        }
         
         if(typeof(giftcard)!== 'undefined' ){
              //  alert("giftcard="+giftcard);
          
             total=Number(total)+Number(giftcard);
          }
           if(typeof(carWash)!== 'undefined' ){
                //alert("carWash="+carWash);
          
             total=Number(total)+Number(carWash);
          }
		   $("#op").hide();
		   $("#sub").show();
		 $("#cost").val(total.toFixed(2));
        $("#totalCost").show();
        $("#totalCost").text("Total cost to be paid: "+total.toFixed(2)+ "$");
		 
		
    });
    
        $("#selectCar").change(function(){
			
        $(this).find("option:selected").each(function(){
            
            if($(this).attr("value")==="29.99"){
				$("#op").show();
              $(".luxury").hide();
              $(".midSize").hide();
                $(".compact").show();
                $('input:checkbox').removeAttr('checked');
             
            }
            else if($(this).attr("value")==="39.99"){
				$("#op").show();
              $(".compact").hide();
               $(".luxury").hide();
              $(".midSize").show();
              $('input:checkbox').removeAttr('checked');
            }
            else if($(this).attr("value")==="49.99"){
				$("#op").show();
               $(".compact").hide();
                $(".midSize").hide();
               $(".luxury").show();
               $('input:checkbox').removeAttr('checked');
            }
            else{
				$("#op").hide();
                $(".compact").hide();
                $(".midSize").hide();
                $(".luxury").hide();
            }

        });

    }).change();
    });
        </script>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="container">
            <form class="form-horizontal" id="orderForm" action="http://localhost:8080/login/CarOrderServlet" method="post">
               
                <div class="form-group">
                    
                    <div class="col-xs-10">
                         <div id="error"></div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="cars" class="col-xs-2">Select a car type</label>
                    <div class="col-xs-10">
                        <p id="selectCar">
                            <select class ="input-sm" name="cars" id="cars">
                             <option name ='cars' value="0">Select one  </option>
                             <option name ='cars' value="29.99">Compact  </option>
                             <option name ='cars' value="39.99">Mid Size</option>
                              <option name ='cars' value="49.99">Luxury</option>    
                                </select>
                         </p> 
                    </div>
                </div>
             <div class="media">
                <a class="pull-left" href="#">
                <img class="media-object compact" src="http://localhost:8080/login/img/ford_fiesta_4dr.png" 
                     alt="compact">
                <img class="media-object midSize" src="http://localhost:8080/login/img/ford_escape_15.png" 
                     alt="midSize">
                 <img class="media-object luxury" src="http://localhost:8080/login/img/lincoln_mks_promo_195.png" 
                     alt="luxury">
                </a>
                <div class="media-body">
                    <h4 class="media-heading compact">Compact</h4>
                    <p class="compact">Price 29.99$</p>
                     <h4 class="media-heading midSize">Mid Size</h4>
                    <p class="midSize">Price 39.99$</p>
                     <h4 class="media-heading luxury">Luxury</h4>
                    <p class="luxury">Price 49.99$</p>
                </div>
             </div>
                <br></br>
    
                <div class="form-group compact midSize luxury">
                    <label for="city" class="col-xs-2">Select a pick up city</label>
                    <div class="col-xs-10">
                        <select class ="input-sm" name="city">
                        <option name="city" value="San Francisco">San Francisco  </option>
                        <option name="city" value="Los Angeles">Los Angeles</option>
                        <option name="city" value="New York">New York</option>    
                        </select>
                    </div>
                </div>
				 <br></br>
    
                <div class="form-group compact midSize luxury">
                    <label for="city" class="col-xs-2">Select a drop city</label>
                    <div class="col-xs-10">
                        <select class ="input-sm" name="dropcity">
                        <option name="dropcity" value="San Francisco">San Francisco  </option>
                        <option name="dropcity" value="Los Angeles">Los Angeles</option>
                        <option name="dropcity" value="New York">New York</option>    
                        </select>
                    </div>
                </div>
         <br>

         <div class="form-group compact midSize luxury">
             <label class="col-xs-2">Start Date</label>
             <input type="date" class="input-sm" id="startDate" name="startDate">
         </div>
        <div class="form-group compact midSize luxury">
             <label class="col-xs-2">End Date</label>
             <input type="date" class="input-sm" id="endDate" name="endDate">
         </div>
        <div class="checkbox compact">
          <label><input type="checkbox" name="iCompact" value="17">Collision insurance is $17.00 / day for compact cars</label>
        </div>
        <div class="checkbox midSize">
          <label><input type="checkbox" name="iMidSize" value="22">Collision insurance is $22.00 / day for mid-size cars</label>
        </div>
         <div class="checkbox luxury">
          <label><input type="checkbox" name="iLuxury" value="28">Collision insurance is $28.00 / day for Luxury cars</label>
        </div>
        <div class="checkbox luxury">
          <label><input type="checkbox" name="giftcard" value="100">Prepaid gift card for gas stations:100$</label>
        </div>
        <div class="checkbox luxury">
          <label><input type="checkbox" name="carWash" value="100" >daily car wash service for the whole rental duration: $50</label>
        </div>
        
              <input type="hidden" name="cost" value="0" id="cost">
              <hr>
                
                <div id="op" class="col-xs-10 col-xs-offset-2">
                    <button id ="submit" type="button" class="btn btn-primary" value="getEstimate">GetEstimate
                    </button>
                </div>
				<div class="row">
                <div class="col-xs-4 1 col1">
                <h4 id="totalCost"></h4>
            </div>
				 <p id='sub' ><button id ="submit1" type="submit" class="btn btn-primary" value="submit">To Book Click Here
                    </button></p>
				 
            </div>
            </form>
      
            <p class="hidden">Total Number Of days <input class='minim' hidden/></p>
     
           

        <hr>
        </div>
        
        <div class="container">
           
        </div>

    <footer class="footer-distributed">

                <div class="footer-left">

                    <img width="200" height="150" style="border: solid 1px;" src="http://localhost:8080/login/logo.jpeg">


                    <p class="footer-company-name">Smart Rental Services &copy; 2015</p>
                </div>

                <div class="footer-center">

                    <div>
                        <i class="fa fa-map-marker"></i>
                        <p><span>Fremont</span> CA, United States</p>
                    </div>

                    <div>
                        <i class="fa fa-phone"></i>
                        <p>+1 123-456-7890</p>
                    </div>

                    <div>
                        <i class="fa fa-envelope"></i>
                        <p><a href="mailto:email">rentalservices@gmail.com</a></p>
                    </div>

                </div>

                <div class="footer-right">

                    <p class="footer-company-about">
                        <span>About the company</span>
                       This Project is Created for Practice..
                    </p>

                    <div class="footer-icons">

                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-linkedin"></i></a>
                        <a href="#"><i class="fa fa-github"></i></a>

                    </div>

                </div>

            </footer>
    </body>
	<script src="http://localhost:8080/login/calc.js"></script>
</html>
