const form = document.getElementById('button')

form.addEventListener('click', input =>
{
    input.preventDefault()

    const email = document.getElementById('email').value
    const password = document.getElementById('password').value

    fetch("demo/getByEmail?email=" + email)
        .then(res => res.json())
        .then(data =>
        {
            if(data.email == email)
            {
                if(data.enabled)
                {
                    fetch("demo/compare?email=" + email + "&password=" + password)
                        .then(response => response.text())
                        .then(isValid =>
                        {
                            if(JSON.parse(isValid))
                            {
                                location.href = "index.html"
                            }
                        })
                }
            }
        })
})