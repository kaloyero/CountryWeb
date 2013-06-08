var ComponentTranslator = new Class(
		{

			initialize : function() {

			},

			onSubmit : function(objectType) {
				
			},

			onSaved : function() {
			
			},

			onUpdate: function() {
			},

			onUpdated : function() {
			
			},

			onLoad : function(objectType, objectId) {
				serverManager.get({
					object : objectType,
					objectId : objectId,
					onSuccess : function(data) {

						canvasController.onLoaded(objectType,data)
					}
				});
			},


			onShow : function(objectType) {
				serverManager.getAll({
					object : objectType,
					onSuccess : function(data) {
						console.log("Data",data)
						canvasController.onFinishShow(objectType,data);
						//self.onShowed(objectType, data);
					}
				});
				//canvasController.onFinishShow(objectType);

			},

			onShowed : function(objectType, data) {

			},

			onPopulateGrid : function(objectType) {

			}

		});

var translator = new ComponentTranslator();
