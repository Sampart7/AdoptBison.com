const productTemplate = document.querySelector("[product-template]")
const productsContainer = document.querySelector("[products-container]")

fetch("/demo/all")
.then(res => res.json())
.then(data =>
{
    data.forEach(product =>
    {
        const template = productTemplate.content.cloneNode(true).children[0]
        const name = template.querySelector("[name]")
        const email = template.querySelector("[email]")
        const your_charity = template.querySelector("[your_charity]")

        name.textContent = product.name
        email.textContent = product.email
        your_charity.textContent = product.your_charity

        console.log("chucjuchcuhcuchcujcu")
        console.log(your_charity)

        productsContainer.append(template)

    })
})