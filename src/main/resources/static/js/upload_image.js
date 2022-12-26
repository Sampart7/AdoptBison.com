const image_input = document.querySelector("#image_input")
var uploaded_image = ""

image_input.addEventListener("change", function (){
    const reader = new FileReader()
    reader.addEventListener("load", () => {
        uploaded_image = reader.result
        document.querySelector("#display_image").style.backgroundImage = `url(${uploaded_image})`
    })
    reader.readAsDataURL(this.files[0])
})

// const imageUrl = "C:/Users/Michał Janaszek/Desktop";
//
// fetch(imageUrl)
//     //
//     .then(response => response.blob())
//     .then(imageBlob => {
//         // Then create a local URL for that image and print it
//         const imageObjectURL = URL.createObjectURL(imageBlob);
//         console.log(imageObjectURL);
//     });