---


---

<p><strong>API Demo</strong></p>
<p>Our main focus for the REST API demo is to conduct the following tasks:</p>
<ul>
<li>Add a new medication to the list of available medications</li>
<li>Create a new patient</li>
<li>Assign a patient a new medication from the list of available medications</li>
<li>Remove a medication from the list of medications assigned to a patient</li>
</ul>
<p><strong>Task 1: Add a new medication</strong><br>
Initially when we set up our REST API some dummy data is already created for the medications endpoint. We can obtain this data using the following REST API call:</p>
<pre><code>GET http://localhost:8080/medications
</code></pre>
<p>We can see what these are in the following screenshot:<br>
<img src="https://sites.google.com/site/rodsmods13/_/rsrc/1539400932067/home/initial_medicine_list.PNG" alt="enter image description here"><br>
Great, now that we know the initial medication list we add a new medication with the following REST API call:</p>
<p><em>NOTE: The API calls where data is being created and updated are sending JSON type data with appropriate headers.  The Spring HAL Browser helps with this.</em></p>
<pre><code>POST http://localhost:8080/medications
</code></pre>
<p>And then if we get the medication list we can see that a “Pill E” has been added to our available medications:<br>
<img src="https://22aca10a-a-62cb3a1a-s-sites.googlegroups.com/site/rodsmods13/home/medicine_e_added.PNG?attachauth=ANoY7crkHj6OrwIHJYh25QjoKd2qjdILSri325jpm8mDnPZ7ygs3QsfFtqbRdvHwVIprQggEzeMUh5v2blgQ_yOoSQvCsGqr3xfShLbHoPTnx1OlKjnJFmVhlxSq8aLTYOU51a_pDjbk9Pk9rTsZ2UQOEKlo1CVmBJ1C3wpPbZWYSc7SwJmZKvFhcyBGspMk0n2naATh5iHM2G-gZIU1OyaPrWKULPJ-M0qzf2nVdshDSAPaAIwTQYo%3D&attredirects=0" alt="enter image description here"></p>
<p><strong>Task 2: Create a new patient</strong><br>
We can create a new patient simply using the following REST API call:</p>
<pre><code>POST http://localhost:8080/profile/patients
</code></pre>
<p>In the process of creating a patient we will give them a name, “John Doe”, an age “37”, and we will assign them some medications to start with.  To know what medications we are capable of assigning we can perform a GET REST API call on medications.  After we have created the patient we will see the following data:<br>
<img src="https://sites.google.com/site/rodsmods13/home/patient_creation.PNG?attredirects=0" alt="enter image description here"></p>
<p><strong>Task 3: Assign a new medication</strong><br>
In patient care it is not uncommon for them to be prescribed a new medication.  We can assign them a new medication from the list of available medications by first doing a GET REST API call on medications.  Then we can do a PATCH REST API call on the patient (In our case there they have an id of 2):</p>
<pre><code>PATCH http://localhost:8080/patients/2
</code></pre>
<p>With the following JSON data being “patched in” to assign the patient a new medication of “Pill C”:</p>
<pre><code>{"meds": [
"Pill C"
]}
</code></pre>
<p>Which when we do a GET REST API call on the patient shows the updated medications below:<br>
<img src="https://sites.google.com/site/rodsmods13/home/patient_med_patch.PNG?attredirects=0" alt="enter image description here"></p>
<p><strong>Task 4: Remove an assigned medication</strong><br>
It is also not uncommon in patient care to need to remove a medication from a treatment plan.  This can also be accomplished with a PATCH REST API call:</p>
<pre><code>PATCH http://localhost:8080/patients/2
</code></pre>
<p>With the following JSON data being patched to reflect the med changes.  In our case we will get rid of all medications assigned except “Pill A”:</p>
<pre><code>{"meds": [
"Pill A"
]}
</code></pre>
<p>Which finally when we do a GET REST API call on the patient shows the updated assigned medication list below:<br>
<img src="https://sites.google.com/site/rodsmods13/home/patient_med_patch_delete.PNG?attredirects=0" alt="enter image description here"></p>
<p><strong>Future Work</strong></p>
<p>The REST API already encompasses principles of HATEOAS, but it can be further expanded with multiple resource linking.  Currently medications assigned to a patient are represented by their String name.  However we could do the following as well:</p>
<pre><code>...
"meds":[{  
 "href":"http://localhost:8080/medications/1"  
},{  
 "href":"http://localhost:8080/medications/2"  
}]
...
</code></pre>
<p>Which would link to Pill A and B respectively.  We could tighten up the REST API to where an error would be thrown and returned in the response body if an medication id was assigned that didn’t exist in the available medication list.</p>

