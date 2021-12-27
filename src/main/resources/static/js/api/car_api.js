async function deleteDeviceByNameA(data, token) {
    return await fetch("/admin/deleteDeviceByNameA", {
        method: 'DELETE',
        headers: {
            'Authorization': `Bearer ${token}`,
            'content-type': 'application/json'
        },
        body: JSON.stringify(data)

    });
}

async function deleteDeviceByNameU(data, token) {
    return await fetch("/user/deleteDeviceByNameU", {
        method: 'DELETE',
        headers: {
            'Authorization': `Bearer ${token}`,
            'content-type': 'application/json'
        },
        body: JSON.stringify(data)

    });
}

async function updateDevice(data, token) {
    return await fetch("/admin/updateDevice", {
        method: 'PUT',
        headers: {
            'Authorization': `Bearer ${token}`,
            'content-type': 'application/json'
        },
        body: JSON.stringify(data)

    });
}

async function userGetDeviceByName(name, token) {
    return await fetch(`/user/userGetDeviceByName/${name}`, {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`,
            'content-type': 'application/json'
        }

    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        return data;
    });
}

async function adminGetDeviceByName(name, token) {
    return await fetch(`/admin/adminGetDeviceByName/${name}`, {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`,
            'content-type': 'application/json'
        }

    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        return data;
    });
}
async function isDeviceExistByName(data, token) {
    return await fetch("/admin/isDeviceExistByName",{
        method :'POST',
        headers: {
            'Authorization': `Bearer ${token}`,
            'content-type': 'application/json'
        },
        body:JSON.stringify(data)

    });
}
async function createDevice(data, token) {
    return await fetch("/admin/createDevice",{
        method :'POST',
        headers: {
            'Authorization': `Bearer ${token}`,
            'content-type': 'application/json'
        },
        body:JSON.stringify(data)

    });
}
async function getAllCompsForAdmin(token) {
    return await fetch(`/admin/getAllCompsForAdmin`, {
        method: "GET",
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        return data;
    });
}
async function getAllCompsForUser(token) {
    return await fetch(`/user/getAllCompsForUser`, {
        method: "GET",
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        return data;
    });
}