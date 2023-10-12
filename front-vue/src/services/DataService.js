import axios from 'axios';

export default class DataService {
    static host = 'http://localhost:8080/';

    static async getData(str){
		var response, data;
        response = await fetch(this.host + str);
        data = await response.json();
        return data;
    }

    static async create(str) {
        var response;
        const requestParams = {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            }
        };
        response = await axios.post(this.host + str, requestParams);  
        return await response.json();      
    }

    static async update(str) {
        var response;
        const requestParams = {
            method: 'PATCH', 
			headers: {
				'Content-Type': 'application/json'
			}
        };
        response = await axios.patch(this.host + str, requestParams);  
        return await response.json();
    }

    static async delete(str) {
		var response;
        const requestParams = {
            method: "DELETE",
        };
        response = await fetch(this.host + str, requestParams);  
        return await response.json(); 
    }
}