import React, { Component } from 'react';
import EmployeeService from "../service/EmployeeService";

class EmployeeComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            employee: {},
            department: {},
            organization: {}
        }
    }

    componentDidMount() {
        EmployeeService.getEmployee().then((response) => {
            this.setState({employee : response.data.employee})
            this.setState({department : response.data.department})
            this.setState({organization : response.data.organization})

            console.log(this.state.employee)
            console.log(this.state.department)
            console.log(this.state.organization)
        })
    }

    render() {
        return (
            <div> <br/><br/>
                <div className='card col-md-6 offset-md-3'>
                    <h3 className='text-center card-header'>View Employee Details</h3>
                    <div className='card-body'>
                        <p><strong>Employee First Name: </strong> {this.state.employee.firstName}</p>
                    </div>
                    <div className='card-body'>
                        <p><strong>Employee Last Name: </strong> {this.state.employee.lastName}</p>
                    </div>
                    <div className='card-body'>
                        <p><strong>Employee E-mail: </strong> {this.state.employee.email}</p>
                    </div>
                </div>
                    <div className='card col-md-6 offset-md-3'>
                        <h3 className='text-center card-header'>View Department Details</h3>
                        <div className='card-body'>

                        <div className='row'>
                            <p><strong>Department Name: </strong> {this.state.department.departmentName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Employee Description: </strong> {this.state.department.departmentDescription}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department Code: </strong> {this.state.department.departmentCode}</p>
                        </div>
                        </div>
                    </div>
                <div className='card col-md-6 offset-md-3'>
                        <h3 className='text-center card-header'>View Organizations Details</h3>
                        <div className='card-body'>

                        <div className='row'>
                            <p><strong>Organization Name: </strong> {this.state.organization.organizationName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Organization Description: </strong> {this.state.organization.organizationDescription}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department Code: </strong> {this.state.organization.organizationCode}</p>
                        </div>
                        </div>
                    </div>
            </div>
        );
    }
}

export default EmployeeComponent;
