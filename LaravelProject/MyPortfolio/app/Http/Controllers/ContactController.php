<?php

namespace App\Http\Controllers;

use App\Contact;
use Request;

use App\Http\Requests;

class ContactController extends Controller
{
    public function index()
    {
        $contacts = Contact::all();
        return view('contact.index')->with('contacts', $contacts);
    }

    public function create()
    {
        return view('contact.create');
    }

    public function store()
    {
        $input = Request::all();

        Contact::create($input);

        return redirect('contact');
    }
}
