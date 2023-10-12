export default class Material {
    constructor(data) {
        this._id = data?.id;
        this._componentName = data?.componentName;
    }

    get id() {
        return this._id;
    }

    get materialname() {
        return this._materialname;
    }

    set materialname(value) {
        if (typeof value !== 'string' || value === null || value.length == 0) {
            throw 'New name value ' + value + ' is not a string or empty';
        }
        this._materialname = value;
    }
}