const form = document.getElementById('button')

form.addEventListener('click', input =>
{
    input.preventDefault()

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const yourCharity = document.getElementById('yourCharity').value;
    const zubrName = document.getElementById('select').value;
    const description = document.getElementById('description').value;
    const image = document.getElementById('image').value;

    // console.log(image)

    if((name!="")&&(email!="")&&(yourCharity!="")&&(zubrName!="")) {
        fetch('/demo/adopt',
            {
                method: 'POST',
                headers:
                    {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                body: JSON.stringify({"name": name, "email": email, "yourCharity": yourCharity, "zubrName": zubrName, "description": description, "image": image})
            })
        location.href = "index.html"
    }
})