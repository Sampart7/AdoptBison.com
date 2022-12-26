const productTemplate3 = document.querySelector("[product-template-3]")
const productsContainer3 = document.querySelector("[products-container-3]")

fetch("/demo/adopted")
    .then(res => res.json())
    .then(data =>
    {
        data.forEach(product =>
        {
            const template = productTemplate3.content.cloneNode(true).children[0]
            const name = template.querySelector("[name]")
            const email = template.querySelector("[email]")
            const yourCharity = template.querySelector("[yourCharity]")
            const zubrName = template.querySelector("[zubrName]")
            const description = template.querySelector("[description]")
            const image = template.querySelector("[image]")

            name.textContent = product.name
            email.textContent = product.email
            yourCharity.textContent = product.yourCharity
            zubrName.textContent = product.zubrName
            description.textContent = product.description

            image.innerHTML = product.image

            productsContainer3.append(template)
        })
    })