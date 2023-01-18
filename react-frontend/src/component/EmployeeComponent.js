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
            <div><br/>
                <div className="container-fluid">
                    <div className="row">
                        <div className="profile-head">
                            <div className="profiles col-xs-8 col-xs-push-2  col-sm-10 col-sm-push-1 thumbnail">
                                <div className="col-md-3 col-sm-3 col-xs-12">
                                    <div className="row">
                                        <img src="https://bootdey.com/img/Content/avatar/avatar6.png"
                                             className="img-responsive"/>
                                    </div>
                                </div>
                                <div className="col-md-9">
                                    <div className="row">
                                        <span className="col-sm-12"><h5>{this.state.employee.firstName} {this.state.employee.lastName}</h5></span>
                                        <div className="col-md-4 col-sm-6 col-xs-12">
                                            <p>{this.state.organization.organizationName}</p>
                                            <ul>
                                                <li><span><strong>Org Code</strong></span></li>
                                                <li><span><strong>E-mail</strong></span></li>
                                                <li><span><strong>Department name</strong></span></li>
                                                <li><span><strong>Department Description</strong></span></li>
                                                <li><span><strong>Department Code</strong></span></li>
                                            </ul>
                                        </div>
                                        <div className="col-md-4 col-sm-6 col-xs-12">
                                            <p>{this.state.organization.organizationDescription}</p>
                                            <ul>
                                                <li><span>{this.state.organization.organizationCode}</span></li>
                                                <li><span>{this.state.employee.email}</span></li>
                                                <li><span>{this.state.department.departmentName}</span></li>
                                                <li><span>{this.state.department.departmentDescription}</span></li>
                                                <li><span>{this.state.department.departmentCode}</span></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default EmployeeComponent;
