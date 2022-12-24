const form = document.getElementById('button')

form.addEventListener('click', input =>
{
    input.preventDefault()

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const yourCharity = document.getElementById('yourCharity').value;
    const zubrName = document.getElementById('select').value;
    const description = document.getElementById('description').value;

    // const zubrName = document.querySelector("[zubrName]")

    if((name!="")&&(email!="")&&(yourCharity!="")&&(zubrName!="")) {
        console.log(zubrName)
        fetch('/demo/adopt',
            {
                method: 'POST',
                headers:
                    {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                body: JSON.stringify({"name": name, "email": email, "yourCharity": yourCharity, "zubrName": zubrName, "description": description})
            })

        location.href = "index.html"
    }
})