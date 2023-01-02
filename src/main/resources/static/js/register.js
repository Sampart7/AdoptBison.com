const form = document.getElementById('button')

form.addEventListener('click', input =>
{
    input.preventDefault()

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const repassword = document.getElementById('repassword').value;


    if((email!="")&&(password!="")&&(repassword!="")) {
        if(password == repassword) {
            fetch('/demo/addUser',
                {
                    method: 'POST',
                    headers:
                        {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                    body: JSON.stringify({"email": email, "password": password, "repassword": repassword})
                })
            location.href = "index.html"
        }
    }
})