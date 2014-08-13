var App = Class.create();

App.prototype={

initialize: function() {},

    loadTable:function() {

        new Ajax.Request('/minrec/list', {
            method:'get',
            onSuccess:function(response) {
                var resp = response.responseText.evalJSON();
                var array = resp.array;
               var i = 0;
               app.clearTable();
                array.each(function(e) {
                 
//                  alert(e.name+' '+e.time+' '+e.status+' '+e.comment);
                  var row =$('listApplicants').insertRow(++i);
                  var check = row.insertCell(0);
                  
                  check.innerHTML='<input type=\"checkbox\" id=\"chk'+i+' \" />';
                  
                  var time = row.insertCell(1);
                  time.innerHTML=e.time;
                  var fio = row.insertCell(2);
                  fio.innerHTML=e.name;
                  var comment = row.insertCell(3);
                  comment.innerHTML=e.comment;
                          var status = row.insertCell(4);
                           status.innerHTML=e.status;
                           
                });
            },
            onComplete: function(response) {
                app.setCleared();
                setTimeout(function(){app.loadTable();}, 5000);
            }
    });
},

    /**
     * Comment
     */
     save: function() {
         new Ajax.Request('/minrec/add', {
             method:'post',
             parameters: {
                 name:$('name').value, comment:$('comment').value
             },
             onLoaded: function() {
                 $('name').value='';
                 $('comment').value='';
             },
             onLoading: function() {
                 $('addButton').disabled=disabled;
             },
             onComplete: function() {
                 $('addButton').disable=false;
             }
         });

    },
    clearTable:function() {
       var table = $('listApplicants');
        app.selectedApp=app.getSelected();
       while(table.rows.length>1) {
           table.deleteRow(1);
       }
       
       
    },
    setStatus: function(stat) {
        
        var arr = app.getSelected();
        var names = [];var j=0;
        var table = $('listApplicants');
        arr.each(function(e) {
            names[j++]=table.rows.item(e).cells[2].innerHTML;
        });
        new Ajax.Request('/minrec/register',{
        method:'post',
        parameters:{array:Object.toJSON(names), status:stat}
    });
        $$('input[type=checkbox]').each(function(e){e.checked=false;});
    },
    
    getSelected:function() {
        var table = $('listApplicants');
        var rows = table.rows;
        var cBoxes = $$('input[type=checkbox]');
        var result = [];
        j=0;
        cBoxes.each(function(e) {
            if(e!=null && e.checked==true){
                result[j]=e.id.substring(3);j++;
            }
        });
    return result;
    },
    setCleared:function() {
        var array = app.selectedApp;
      array.each(function(e){
         var table = $('listApplicants');
         var box = table.rows.item(e).cells[0].childNodes[0];
         box.checked=true;
      });
    }
};

var app = new App();
