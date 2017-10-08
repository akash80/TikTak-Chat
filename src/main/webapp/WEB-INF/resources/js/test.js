/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function testForm()
{
 $.ajax({
  type: 'post',
  url: 'testData',
  data: {
      name:"akash"
  },
  success: function (response) {
   var obj = JSON.parse(response);
   alert(obj.name);
  }
 });
	
 return false;
}

