# Map-activity
Aplicacion de GoogleMap en Android 


**MainActivity**
<img width="960" alt="ActivityMap-image" src="https://user-images.githubusercontent.com/66187218/84545974-aafe6900-acd6-11ea-9766-8f58f8e6dd45.png">

- Tipear las coordenadas en `EditText` Latitud y `EditText` Longitud para buscar el lugar 
- Luego aceptamos y nos dirigimos al MapActivity

**MapActivity**
<img width="959" alt="ActivityMap2-image" src="https://user-images.githubusercontent.com/66187218/84546805-81464180-acd8-11ea-92a5-72a5ab41a11d.png">

- Añadi un `MarkerOptions` personalizado con un titulo 

**GoogleMap**

<img width="752" alt="Map_Activity3-image" src="https://user-images.githubusercontent.com/66187218/84547897-d5522580-acda-11ea-8dca-5d701ace860d.png">

**IMPLEMENTACION**

1. Implementamos `GoogleMap.OnMarkerDragListener `  en el Activity

- **Gracias al `Geocoder` obtenemos :**
- address = `.get(0).getAddressLine(0)`
- city = `.get(0).getLocality()`
- state = `.get(0).getAdminArea()`
- country = `.get(0).getCountryName()`
- postalCode  = `.get(0).getPostalCode()`

2. Introducimos el codigo por ejemplo en `setSnippet(address)`

3. Lo mostramos con `.showInfoWindow();`
