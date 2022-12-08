const form = document.getElementById('form')

form.addEventListener("submit", input =>
{
    console.log("adsfladsfjldkaf")
    input.preventDefault()

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const zubr_name = document.getElementById('zubr_name').value;
    const your_charity = document.getElementById('your_charity').value;

    fetch('registration',
        {
            method: 'POST',
            headers:
                {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
            body: JSON.stringify({ "name": name, "zubr_name": zubr_name, "your_charity": your_charity, "email": email})
        }).then(()=>{
            console.log("fetched")
    })

    location.href = "adopt.html"
})
