<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>HighTech - IT Solutions Website Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600&family=Saira:wght@500;600;700&display=swap"
        rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap5.min.css" rel="stylesheet">
    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    


    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
    <link href="https://cdn.datatables.net/1.13.7/js/dataTables.bootstrap5.min.js" rel="stylesheet">
    
    <!-- <link href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css" rel="stylesheet">
     -->
    

    
</head>

<body>

    <script>
        $(document).ready(function(){
            console.log("hello");
            new DataTable('#example');
        });
    </script>

    <!-- Spinner Start -->
    <div id="spinner"
        class="show position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-grow text-primary" role="status"></div>
    </div>
    <!-- Spinner End -->

    <!-- Topbar Start -->
    <div class="container-fluid bg-dark py-2 d-none d-md-flex">
        <div class="container">
            <div class="d-flex justify-content-between topbar">
                <div class="top-info">
                    <small class="me-3 text-white-50"><a href="#"><i
                                class="fas fa-map-marker-alt me-2 text-secondary"></i></a>Karadigollapatti,
                        India</small>
                    <small class="me-3 text-white-50"><a href="#"><i
                                class="fas fa-envelope me-2 text-secondary"></i></a>gurukalvi.system@gmail.com</small>
                </div>
                <div id="note" class="text-secondary d-none d-xl-flex"><small>Note : Start Learning for your
                        future</small></div>
                <div class="top-link">
                    <a href="" class="bg-light nav-fill btn btn-sm-square rounded-circle"><i
                            class="fab fa-facebook-f text-primary"></i></a>
                    <a href="" class="bg-light nav-fill btn btn-sm-square rounded-circle"><i
                            class="fab fa-twitter text-primary"></i></a>
                    <a href="" class="bg-light nav-fill btn btn-sm-square rounded-circle"><i
                            class="fab fa-instagram text-primary"></i></a>
                    <a href="" class="bg-light nav-fill btn btn-sm-square rounded-circle me-0"><i
                            class="fab fa-linkedin-in text-primary"></i></a>
                </div>
            </div>
        </div>
    </div>
    <!-- Topbar End -->

    <!-- Navbar Start -->
    <div class="container-fluid bg-primary">
        <div class="container">
            <nav class="navbar navbar-dark navbar-expand-lg py-0">
                <a href="index.html" class="navbar-brand">
                    <h1 class="text-black-50 fw-bold d-block">Guru Tech </h1>
                </a>
                <button type="button" class="navbar-toggler me-0" data-bs-toggle="collapse"
                    data-bs-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse bg-transparent" id="navbarCollapse">
                    <div class="navbar-nav ms-auto mx-xl-auto p-0">
                        <a href="index.html" class="nav-item nav-link">Home</a>
                        <a href="about.jsp" class="nav-item nav-link">About</a>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Courses</a>
                            <div class="dropdown-menu rounded">
                                <a href="java.jsp" class="dropdown-item">Java</a>
                                <a href="python.jsp" class="dropdown-item">Python</a>
                                <a href="reactjs.jsp" class="dropdown-item">ReactJs</a>

                            </div>
                        </div>


                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle active text-secondary"
                                data-bs-toggle="dropdown">Test</a>
                            <div class="dropdown-menu rounded">
                                <a href="question.jsp" class="dropdown-item">Questions</a>
                                <a href="edit_question.jsp" class="dropdown-item">Edit Question</a>
                                <a href="create_exam.jsp" class="dropdown-item">Create Exam</a>
                                <a href="edit_exam.jsp" class="dropdown-item">Edit Exam</a>
                              <a href="topic.jsp" class="dropdown-item">Create Topic</a>
                                <a href="edit_topic.jsp" class="dropdown-item">Edit Topic</a>
                            </div>
                        </div>
                        <a href="testimonial.jsp" class="nav-item nav-link">Testimonial</a>
                        <a href="contact.jsp" class="nav-item nav-link">Contact</a>
                        <a href="login.jsp" class="nav-item nav-link">Login</a>
                    </div>
                </div>
                <div class="d-none d-xl-flex flex-shirink-0">
                    <div id="phone-tada" class="d-flex align-items-center justify-content-center me-4">
                        <a href="" class="position-relative animated tada infinite">
                            <i class="fa fa-phone-alt text-white fa-2x"></i>
                            <div class="position-absolute" style="top: -7px; left: 20px;">
                                <span><i class="fa fa-comment-dots text-secondary"></i></span>
                            </div>
                        </a>
                    </div>
                    <div class="d-flex flex-column pe-4 border-end">
                        <span class="text-white-50">Have any questions?</span>
                        <span class="text-secondary">Call: + 0123 456 7890</span>
                    </div>
                    <div class="d-flex align-items-center justify-content-center ms-4 ">
                        <a href="#"><i class="bi bi-search text-white fa-2x"></i> </a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
    <!-- Navbar End -->


    <!-- Page Header Start -->
    <div class="container-fluid page-header py-5">
        <div class="container text-center py-5">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-8" style="display: flex; flex-direction: column;" >
                        <table id="example" class="table table-bordered table-dark" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Position</th>
                                    <th>Office</th>
                                    <th>Age</th>
                                    <th>Start date</th>
                                    <th>Salary</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Tiger Nixon</td>
                                    <td>System Architect</td>
                                    <td>Edinburgh</td>
                                    <td>61</td>
                                    <td>2011-04-25</td>
                                    <td>$320,800</td>
                                </tr>
                                <tr>
                                    <td>Garrett Winters</td>
                                    <td>Accountant</td>
                                    <td>Tokyo</td>
                                    <td>63</td>
                                    <td>2011-07-25</td>
                                    <td>$170,750</td>
                                </tr>
                                <tr>
                                    <td>Ashton Cox</td>
                                    <td>Junior Technical Author</td>
                                    <td>San Francisco</td>
                                    <td>66</td>
                                    <td>2009-01-12</td>
                                    <td>$86,000</td>
                                </tr>
                                <tr>
                                    <td>Cedric Kelly</td>
                                    <td>Senior Javascript Developer</td>
                                    <td>Edinburgh</td>
                                    <td>22</td>
                                    <td>2012-03-29</td>
                                    <td>$433,060</td>
                                </tr>
                                <tr>
                                    <td>Airi Satou</td>
                                    <td>Accountant</td>
                                    <td>Tokyo</td>
                                    <td>33</td>
                                    <td>2008-11-28</td>
                                    <td>$162,700</td>
                                </tr>
                                <tr>
                                    <td>Brielle Williamson</td>
                                    <td>Integration Specialist</td>
                                    <td>New York</td>
                                    <td>61</td>
                                    <td>2012-12-02</td>
                                    <td>$372,000</td>
                                </tr>
                                <tr>
                                    <td>Herrod Chandler</td>
                                    <td>Sales Assistant</td>
                                    <td>San Francisco</td>
                                    <td>59</td>
                                    <td>2012-08-06</td>
                                    <td>$137,500</td>
                                </tr>
                                <tr>
                                    <td>Rhona Davidson</td>
                                    <td>Integration Specialist</td>
                                    <td>Tokyo</td>
                                    <td>55</td>
                                    <td>2010-10-14</td>
                                    <td>$327,900</td>
                                </tr>
                                <tr>
                                    <td>Colleen Hurst</td>
                                    <td>Javascript Developer</td>
                                    <td>San Francisco</td>
                                    <td>39</td>
                                    <td>2009-09-15</td>
                                    <td>$205,500</td>
                                </tr>
                                <tr>
                                    <td>Sonya Frost</td>
                                    <td>Software Engineer</td>
                                    <td>Edinburgh</td>
                                    <td>23</td>
                                    <td>2008-12-13</td>
                                    <td>$103,600</td>
                                </tr>
                                <tr>
                                    <td>Jena Gaines</td>
                                    <td>Office Manager</td>
                                    <td>London</td>
                                    <td>30</td>
                                    <td>2008-12-19</td>
                                    <td>$90,560</td>
                                </tr>
                                <tr>
                                    <td>Quinn Flynn</td>
                                    <td>Support Lead</td>
                                    <td>Edinburgh</td>
                                    <td>22</td>
                                    <td>2013-03-03</td>
                                    <td>$342,000</td>
                                </tr>
                                <tr>
                                    <td>Charde Marshall</td>
                                    <td>Regional Director</td>
                                    <td>San Francisco</td>
                                    <td>36</td>
                                    <td>2008-10-16</td>
                                    <td>$470,600</td>
                                </tr>
                                <tr>
                                    <td>Haley Kennedy</td>
                                    <td>Senior Marketing Designer</td>
                                    <td>London</td>
                                    <td>43</td>
                                    <td>2012-12-18</td>
                                    <td>$313,500</td>
                                </tr>
                                <tr>
                                    <td>Tatyana Fitzpatrick</td>
                                    <td>Regional Director</td>
                                    <td>London</td>
                                    <td>19</td>
                                    <td>2010-03-17</td>
                                    <td>$385,750</td>
                                </tr>
                                <tr>
                                    <td>Michael Silva</td>
                                    <td>Marketing Designer</td>
                                    <td>London</td>
                                    <td>66</td>
                                    <td>2012-11-27</td>
                                    <td>$198,500</td>
                                </tr>
                                <tr>
                                    <td>Paul Byrd</td>
                                    <td>Chief Financial Officer (CFO)</td>
                                    <td>New York</td>
                                    <td>64</td>
                                    <td>2010-06-09</td>
                                    <td>$725,000</td>
                                </tr>
                                <tr>
                                    <td>Gloria Little</td>
                                    <td>Systems Administrator</td>
                                    <td>New York</td>
                                    <td>59</td>
                                    <td>2009-04-10</td>
                                    <td>$237,500</td>
                                </tr>
                                <tr>
                                    <td>Bradley Greer</td>
                                    <td>Software Engineer</td>
                                    <td>London</td>
                                    <td>41</td>
                                    <td>2012-10-13</td>
                                    <td>$132,000</td>
                                </tr>
                                <tr>
                                    <td>Dai Rios</td>
                                    <td>Personnel Lead</td>
                                    <td>Edinburgh</td>
                                    <td>35</td>
                                    <td>2012-09-26</td>
                                    <td>$217,500</td>
                                </tr>
                                <tr>
                                    <td>Jenette Caldwell</td>
                                    <td>Development Lead</td>
                                    <td>New York</td>
                                    <td>30</td>
                                    <td>2011-09-03</td>
                                    <td>$345,000</td>
                                </tr>
                                <tr>
                                    <td>Yuri Berry</td>
                                    <td>Chief Marketing Officer (CMO)</td>
                                    <td>New York</td>
                                    <td>40</td>
                                    <td>2009-06-25</td>
                                    <td>$675,000</td>
                                </tr>
                                <tr>
                                    <td>Caesar Vance</td>
                                    <td>Pre-Sales Support</td>
                                    <td>New York</td>
                                    <td>21</td>
                                    <td>2011-12-12</td>
                                    <td>$106,450</td>
                                </tr>
                                <tr>
                                    <td>Doris Wilder</td>
                                    <td>Sales Assistant</td>
                                    <td>Sydney</td>
                                    <td>23</td>
                                    <td>2010-09-20</td>
                                    <td>$85,600</td>
                                </tr>
                                <tr>
                                    <td>Angelica Ramos</td>
                                    <td>Chief Executive Officer (CEO)</td>
                                    <td>London</td>
                                    <td>47</td>
                                    <td>2009-10-09</td>
                                    <td>$1,200,000</td>
                                </tr>
                                <tr>
                                    <td>Gavin Joyce</td>
                                    <td>Developer</td>
                                    <td>Edinburgh</td>
                                    <td>42</td>
                                    <td>2010-12-22</td>
                                    <td>$92,575</td>
                                </tr>
                                <tr>
                                    <td>Jennifer Chang</td>
                                    <td>Regional Director</td>
                                    <td>Singapore</td>
                                    <td>28</td>
                                    <td>2010-11-14</td>
                                    <td>$357,650</td>
                                </tr>
                                <tr>
                                    <td>Brenden Wagner</td>
                                    <td>Software Engineer</td>
                                    <td>San Francisco</td>
                                    <td>28</td>
                                    <td>2011-06-07</td>
                                    <td>$206,850</td>
                                </tr>
                                <tr>
                                    <td>Fiona Green</td>
                                    <td>Chief Operating Officer (COO)</td>
                                    <td>San Francisco</td>
                                    <td>48</td>
                                    <td>2010-03-11</td>
                                    <td>$850,000</td>
                                </tr>
                                <tr>
                                    <td>Shou Itou</td>
                                    <td>Regional Marketing</td>
                                    <td>Tokyo</td>
                                    <td>20</td>
                                    <td>2011-08-14</td>
                                    <td>$163,000</td>
                                </tr>
                                <tr>
                                    <td>Michelle House</td>
                                    <td>Integration Specialist</td>
                                    <td>Sydney</td>
                                    <td>37</td>
                                    <td>2011-06-02</td>
                                    <td>$95,400</td>
                                </tr>
                                <tr>
                                    <td>Suki Burks</td>
                                    <td>Developer</td>
                                    <td>London</td>
                                    <td>53</td>
                                    <td>2009-10-22</td>
                                    <td>$114,500</td>
                                </tr>
                                <tr>
                                    <td>Prescott Bartlett</td>
                                    <td>Technical Author</td>
                                    <td>London</td>
                                    <td>27</td>
                                    <td>2011-05-07</td>
                                    <td>$145,000</td>
                                </tr>
                                <tr>
                                    <td>Gavin Cortez</td>
                                    <td>Team Leader</td>
                                    <td>San Francisco</td>
                                    <td>22</td>
                                    <td>2008-10-26</td>
                                    <td>$235,500</td>
                                </tr>
                                <tr>
                                    <td>Martena Mccray</td>
                                    <td>Post-Sales support</td>
                                    <td>Edinburgh</td>
                                    <td>46</td>
                                    <td>2011-03-09</td>
                                    <td>$324,050</td>
                                </tr>
                                <tr>
                                    <td>Unity Butler</td>
                                    <td>Marketing Designer</td>
                                    <td>San Francisco</td>
                                    <td>47</td>
                                    <td>2009-12-09</td>
                                    <td>$85,675</td>
                                </tr>
                                <tr>
                                    <td>Howard Hatfield</td>
                                    <td>Office Manager</td>
                                    <td>San Francisco</td>
                                    <td>51</td>
                                    <td>2008-12-16</td>
                                    <td>$164,500</td>
                                </tr>
                                <tr>
                                    <td>Hope Fuentes</td>
                                    <td>Secretary</td>
                                    <td>San Francisco</td>
                                    <td>41</td>
                                    <td>2010-02-12</td>
                                    <td>$109,850</td>
                                </tr>
                                <tr>
                                    <td>Vivian Harrell</td>
                                    <td>Financial Controller</td>
                                    <td>San Francisco</td>
                                    <td>62</td>
                                    <td>2009-02-14</td>
                                    <td>$452,500</td>
                                </tr>
                                <tr>
                                    <td>Timothy Mooney</td>
                                    <td>Office Manager</td>
                                    <td>London</td>
                                    <td>37</td>
                                    <td>2008-12-11</td>
                                    <td>$136,200</td>
                                </tr>
                                <tr>
                                    <td>Jackson Bradshaw</td>
                                    <td>Director</td>
                                    <td>New York</td>
                                    <td>65</td>
                                    <td>2008-09-26</td>
                                    <td>$645,750</td>
                                </tr>
                                <tr>
                                    <td>Olivia Liang</td>
                                    <td>Support Engineer</td>
                                    <td>Singapore</td>
                                    <td>64</td>
                                    <td>2011-02-03</td>
                                    <td>$234,500</td>
                                </tr>
                                <tr>
                                    <td>Bruno Nash</td>
                                    <td>Software Engineer</td>
                                    <td>London</td>
                                    <td>38</td>
                                    <td>2011-05-03</td>
                                    <td>$163,500</td>
                                </tr>
                                <tr>
                                    <td>Sakura Yamamoto</td>
                                    <td>Support Engineer</td>
                                    <td>Tokyo</td>
                                    <td>37</td>
                                    <td>2009-08-19</td>
                                    <td>$139,575</td>
                                </tr>
                                <tr>
                                    <td>Thor Walton</td>
                                    <td>Developer</td>
                                    <td>New York</td>
                                    <td>61</td>
                                    <td>2013-08-11</td>
                                    <td>$98,540</td>
                                </tr>
                                <tr>
                                    <td>Finn Camacho</td>
                                    <td>Support Engineer</td>
                                    <td>San Francisco</td>
                                    <td>47</td>
                                    <td>2009-07-07</td>
                                    <td>$87,500</td>
                                </tr>
                                <tr>
                                    <td>Serge Baldwin</td>
                                    <td>Data Coordinator</td>
                                    <td>Singapore</td>
                                    <td>64</td>
                                    <td>2012-04-09</td>
                                    <td>$138,575</td>
                                </tr>
                                <tr>
                                    <td>Zenaida Frank</td>
                                    <td>Software Engineer</td>
                                    <td>New York</td>
                                    <td>63</td>
                                    <td>2010-01-04</td>
                                    <td>$125,250</td>
                                </tr>
                                <tr>
                                    <td>Zorita Serrano</td>
                                    <td>Software Engineer</td>
                                    <td>San Francisco</td>
                                    <td>56</td>
                                    <td>2012-06-01</td>
                                    <td>$115,000</td>
                                </tr>
                                <tr>
                                    <td>Jennifer Acosta</td>
                                    <td>Junior Javascript Developer</td>
                                    <td>Edinburgh</td>
                                    <td>43</td>
                                    <td>2013-02-01</td>
                                    <td>$75,650</td>
                                </tr>
                                <tr>
                                    <td>Cara Stevens</td>
                                    <td>Sales Assistant</td>
                                    <td>New York</td>
                                    <td>46</td>
                                    <td>2011-12-06</td>
                                    <td>$145,600</td>
                                </tr>
                                <tr>
                                    <td>Hermione Butler</td>
                                    <td>Regional Director</td>
                                    <td>London</td>
                                    <td>47</td>
                                    <td>2011-03-21</td>
                                    <td>$356,250</td>
                                </tr>
                                <tr>
                                    <td>Lael Greer</td>
                                    <td>Systems Administrator</td>
                                    <td>London</td>
                                    <td>21</td>
                                    <td>2009-02-27</td>
                                    <td>$103,500</td>
                                </tr>
                                <tr>
                                    <td>Jonas Alexander</td>
                                    <td>Developer</td>
                                    <td>San Francisco</td>
                                    <td>30</td>
                                    <td>2010-07-14</td>
                                    <td>$86,500</td>
                                </tr>
                                <tr>
                                    <td>Shad Decker</td>
                                    <td>Regional Director</td>
                                    <td>Edinburgh</td>
                                    <td>51</td>
                                    <td>2008-11-13</td>
                                    <td>$183,000</td>
                                </tr>
                                <tr>
                                    <td>Michael Bruce</td>
                                    <td>Javascript Developer</td>
                                    <td>Singapore</td>
                                    <td>29</td>
                                    <td>2011-06-27</td>
                                    <td>$183,000</td>
                                </tr>
                                <tr>
                                    <td>Donna Snider</td>
                                    <td>Customer Support</td>
                                    <td>New York</td>
                                    <td>27</td>
                                    <td>2011-01-25</td>
                                    <td>$112,000</td>
                                </tr>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>Name</th>
                                    <th>Position</th>
                                    <th>Office</th>
                                    <th>Age</th>
                                    <th>Start date</th>
                                    <th>Salary</th>
                                </tr>
                            </tfoot>
                        </table>


                    </div>
                    <div class="col-4 p-2 rounded contact-form fadeIn" style="display: flex; flex-direction: column;">
                        <form class="row g-3 needs-validation" novalidate>
                                
                            <div class="mb-4">
                                <textarea class="w-100 form-control border-0 py-3" rows="6" cols="10" placeholder="Question Description" required ></textarea>
                            </div>
                            <div class="mb-4">
                                <input type="email" class="form-control border-0 py-3" placeholder="Option 1">
                            </div>
                            <div class="mb-4">
                                <input type="text" class="form-control border-0 py-3" placeholder="Option 2">
                            </div>
                            <div class="mb-4">
                                <input type="text" class="form-control border-0 py-3" placeholder="Option 3">
                            </div>
                            <div class="mb-4">
                                <input type="text" class="form-control border-0 py-3" placeholder="Option 4">
                            </div>
                            <div class="mb-4">
                                <input type="text" class="form-control border-0 py-3" placeholder="Correct Answer">
                            </div>
                            <div class="mb-4">
                                <textarea class="w-100 form-control border-0 py-3" rows="6" cols="10" placeholder="Answer Explaination"></textarea>
                            </div>
                            <div class="text-start d-flex justify-content-center">
                                <button class="btn btn-dark  text-white py-3 px-5" type="submit">Update</button> &nbsp;
                                <button class="btn btn-secondary text-white py-3 px-5" type="reset">Reset</button> &nbsp;
                            </div>
                            
                         </form> 
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Page Header End -->




    <!-- Footer Start -->
    <div class="container-fluid footer bg-dark wow fadeIn" data-wow-delay=".3s">
        <div class="container pt-5 pb-4">
            <div class="row g-5">
                <div class="col-lg-3 col-md-6">
                    <a href="index.html">
                        <h1 class="text-white fw-bold d-block">High<span class="text-secondary">Tech</span> </h1>
                    </a>
                    <p class="mt-4 text-light">Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta facere
                        delectus qui placeat inventore consectetur repellendus optio debitis.</p>
                    <div class="d-flex hightech-link">
                        <a href="" class="btn-light nav-fill btn btn-square rounded-circle me-2"><i
                                class="fab fa-facebook-f text-primary"></i></a>
                        <a href="" class="btn-light nav-fill btn btn-square rounded-circle me-2"><i
                                class="fab fa-twitter text-primary"></i></a>
                        <a href="" class="btn-light nav-fill btn btn-square rounded-circle me-2"><i
                                class="fab fa-instagram text-primary"></i></a>
                        <a href="" class="btn-light nav-fill btn btn-square rounded-circle me-0"><i
                                class="fab fa-linkedin-in text-primary"></i></a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <a href="#" class="h3 text-secondary">Short Link</a>
                    <div class="mt-4 d-flex flex-column short-link">
                        <a href="" class="mb-2 text-white"><i class="fas fa-angle-right text-secondary me-2"></i>About
                            us</a>
                        <a href="" class="mb-2 text-white"><i class="fas fa-angle-right text-secondary me-2"></i>Contact
                            us</a>
                        <a href="" class="mb-2 text-white"><i class="fas fa-angle-right text-secondary me-2"></i>Our
                            Services</a>
                        <a href="" class="mb-2 text-white"><i class="fas fa-angle-right text-secondary me-2"></i>Our
                            Projects</a>
                        <a href="" class="mb-2 text-white"><i class="fas fa-angle-right text-secondary me-2"></i>Latest
                            Blog</a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <a href="#" class="h3 text-secondary">Help Link</a>
                    <div class="mt-4 d-flex flex-column help-link">
                        <a href="" class="mb-2 text-white"><i class="fas fa-angle-right text-secondary me-2"></i>Terms
                            Of use</a>
                        <a href="" class="mb-2 text-white"><i class="fas fa-angle-right text-secondary me-2"></i>Privacy
                            Policy</a>
                        <a href="" class="mb-2 text-white"><i
                                class="fas fa-angle-right text-secondary me-2"></i>Helps</a>
                        <a href="" class="mb-2 text-white"><i
                                class="fas fa-angle-right text-secondary me-2"></i>FQAs</a>
                        <a href="" class="mb-2 text-white"><i
                                class="fas fa-angle-right text-secondary me-2"></i>Contact</a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <a href="#" class="h3 text-secondary">Contact Us</a>
                    <div class="text-white mt-4 d-flex flex-column contact-link">
                        <a href="#" class="pb-3 text-light border-bottom border-primary"><i
                                class="fas fa-map-marker-alt text-secondary me-2"></i> 123 Street, New York, USA</a>
                        <a href="#" class="py-3 text-light border-bottom border-primary"><i
                                class="fas fa-phone-alt text-secondary me-2"></i> +123 456 7890</a>
                        <a href="#" class="py-3 text-light border-bottom border-primary"><i
                                class="fas fa-envelope text-secondary me-2"></i> info@exmple.con</a>
                    </div>
                </div>
            </div>
            <hr class="text-light mt-5 mb-4">
            <div class="row">
                <div class="col-md-6 text-center text-md-start">
                    <span class="text-light"><a href="#" class="text-secondary"><i
                                class="fas fa-copyright text-secondary me-2"></i>Your Site Name</a>, All right
                        reserved.</span>
                </div>
                <div class="col-md-6 text-center text-md-end">
                    <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                    <span class="text-light">Designed By<a href="https://htmlcodex.com" class="text-secondary">HTML
                            Codex</a> Distributed By <a href="https://themewagon.com">ThemeWagon</a></span>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-secondary btn-square rounded-circle back-to-top"><i
            class="fa fa-arrow-up text-white"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>