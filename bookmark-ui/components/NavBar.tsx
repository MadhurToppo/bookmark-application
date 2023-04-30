import React from 'react';
import Link from "next/link";

const NavBar = () => (
  <div>
    <header>
      <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div className="container-fluid">
          <Link href="/" legacyBehavior><a className="navbar-brand">Bookmark</a></Link>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                  data-bs-target="#navbarCollapse" aria-controls="navbarCollapse"
                  aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarCollapse">
            <ul className="navbar-nav ms-auto">
              <li className="nav-item">
                <Link href="/bookmarks/add" legacyBehavior><a className="nav-link">Add Bookmark</a></Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
  </div>
);

export default NavBar;