$(function() {
  var $image = $(".cropper"),
      $dataX = $("#dataX"),
      $dataY = $("#dataY"),
      $dataHeight = $("#dataHeight"),
      $dataWidth = $("#dataWidth"),
      console = window.console || {log:$.noop},
      cropper;
      
  var crop_x;
  var crop_y;
  var crop_width;
  var crop_height;

  $image.cropper({
    aspectRatio: 1,
    // autoCropArea: 1,
    data: {
      x: 420,
      y: 50,
      width: 800,
      height: 800
    },
    preview: ".preview",

    // multiple: true,
    // autoCrop: false,
    // dragCrop: false,
    // dashed: false,
    // modal: false,
    // movable: false,
    // resizable: false,
    zoomable: false,
    // rotatable: false,
    // checkImageOrigin: false,

    // maxWidth: 480,
    // maxHeight: 270,
    // minWidth: 160,
    // minHeight: 90,

    done: function(data) {
      $dataX.val(data.x);
      $dataY.val(data.y);
      $dataHeight.val(data.height);
      $dataWidth.val(data.width);
      
      crop_x = data.x;
      crop_y = data.y;
      crop_width = data.width;
      crop_height = data.height;
    },

    build: function(e) {
      console.log(e.type);
    },

    built: function(e) {
      console.log(e.type);
    },

    dragstart: function(e) {
      console.log(e.type);
    },

    dragmove: function(e) {
      console.log(e.type);
    },

    dragend: function(e) {
      console.log(e.type);
    }
  });

  cropper = $image.data("cropper");

  $image.on({
    "build.cropper": function(e) {
      console.log(e.type);
      // e.preventDefault();
    },
    "built.cropper": function(e) {
      console.log(e.type);
      // e.preventDefault();
    },
    "dragstart.cropper": function(e) {
      console.log(e.type);
      // e.preventDefault();
    },
    "dragmove.cropper": function(e) {
      console.log(e.type);
      // e.preventDefault();
    },
    "dragend.cropper": function(e) {
      console.log(e.type);
      // e.preventDefault();
    }
  });

  var imgUrlSelector = "#product_form\\:replace_with";
  $("#replace-url-trigger").on("click", function() {
//    alert("qwe" + $(imgUrlSelector).html());
    $image.cropper("replace", $(imgUrlSelector).html());
  });
  
  $("#product_form\\:crop-button").click(function(){
      var cropRegion = {
          x: crop_x,
          y: crop_y,
          width: crop_width,
          height: crop_height
      };
      sendCropParameters(JSON.stringify(cropRegion));
  });

});

function changeImage(){
//    alert("changeImage function");
    $("#replace-url-trigger").trigger("click");
    $(".image-cropper-wrapper").removeClass("undisplayed");
}
