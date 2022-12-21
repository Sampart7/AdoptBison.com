const productTemplate = document.querySelector("[product-template-2]")

fetch("/demo/all")
.then(res => res.json())
.then(data =>
{
    data.forEach(product =>
    {
        const template = productTemplate.content.cloneNode(true).children[0]
        const zubrName = template.querySelector("[zubrName]")

        zubrName.textContent = product.zubrName

        let ele = document.getElementById('select');
        ele.innerHTML = ele.innerHTML + '<option id="zubrName">' + zubrName.textContent + '</option>';
    })
})