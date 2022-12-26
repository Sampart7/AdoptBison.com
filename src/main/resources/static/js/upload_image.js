const image_input = document.querySelector("#image_input")
var uploaded_image = ""

image_input.addEventListener("change", function (){
    const reader = new FileReader()
    reader.addEventListener("load", () => {
        uploaded_image = reader.result

        let birds = document.querySelector("#display_image").style.backgroundImage = `url(${uploaded_image})`
        birds.replace("\"", "&quot;")
        console.log(birds)

        birds = '<div id="display_image" style="background-image: ' + birds + ';"></div>'
        console.log(birds)
    })
    reader.readAsDataURL(this.files[0])
})