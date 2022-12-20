const productTemplate = document.querySelector("[product-template]")
const productsContainer = document.querySelector("[products-container]")

console.log("jebac policje 120")


fetch("/demo/all")
.then(res => res.json())
.then(data =>
{
    data.forEach(product =>
    {
        const template = productTemplate.content.cloneNode(true).children[0]
        const name = template.querySelector("[name]")
        const email = template.querySelector("[email]")
        const yourCharity = template.querySelector("[yourCharity]")
        const zubrName = template.querySelector("[zubrName]")

        name.textContent = product.name
        email.textContent = product.email
        yourCharity.textContent = product.yourCharity
        zubrName.textContent = product.zubrName

        productsContainer.append(template)

    })
})