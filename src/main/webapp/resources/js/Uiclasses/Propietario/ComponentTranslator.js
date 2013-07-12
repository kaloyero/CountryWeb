var ComponentTranslator = new Class(
		{

			initialize : function() {

			},

			onSubmit : function(objectType) {
		    	var formToSend=$(".formulario");
		    	serverManager.save({
					object : objectType,
					form : formToSend,
					onSuccess : function(data) {
						console.log("SEsese")
								$.jGrowl("Creado con exito.", {
									theme : 'success'
								});
					}
				});
			},

			onSaved : function() {
			
			},

			onUpdate: function() {
			},

			onUpdated : function() {
			
			},

			onLoad : function(objectType, objectId) {
				var type = objectType.split('_')[0];
				serverManager.getObjectById({
					object : objectType,
					objectId : objectId,
					onSuccess : function(data) {

						canvasController.onLoaded(type,data);
					}
				});
			},
			
			showForm : function(objectType) {
				var type = objectType.split('_')[0];
				serverManager.getNewObject({
					object : objectType,
					onSuccess : function(data) {

						canvasController.onLoaded(type,data);
					}
				});
			},


			onList : function(objectType) {
				var type = objectType.split('_')[0];
				serverManager.getAll({
					object : objectType,
					onSuccess : function(data) {
						console.log("Data",data)
						canvasController.onFinishShow(type,data);
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
