const productTemplate = document.querySelector("[product-template]")
const productsContainer = document.querySelector("[products-container]")

fetch("/demo/all")
    .then(res => res.json())
    .then(data =>
    {
        data.forEach(product =>
        {
            const template = productTemplate.content.cloneNode(true).children[0]
            const yourCharity = template.querySelector("[yourCharity]")
            const zubrName = template.querySelector("[zubrName]")
            const image = template.querySelector("[image]")

            yourCharity.textContent = product.yourCharity
            zubrName.textContent = product.zubrName

            image.innerHTML = product.image

            productsContainer.append(template)
        })
    })