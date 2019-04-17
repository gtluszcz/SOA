package Beans;

import Logic.MonsterQuery;
import Models.*;
import Repositories.AuthorRepository;
import Repositories.BookRepository;
import Repositories.LoanRepository;
import Repositories.UserRepository;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;


@ManagedBean(name = "Search")
@ApplicationScoped
public class SearchBean {
    BookRepository bookRepo = new BookRepository();
    UserRepository userRepo = new UserRepository();
    LoanRepository loanRepo = new LoanRepository();
    AuthorRepository authorRepo = new AuthorRepository();
    MonsterQuery monsterQuery = new MonsterQuery();

    User selectedUser;
    Author selectedAuthor;
    Book selectedBook;

    public void removeBook(Book book){
        bookRepo.removeBook(book);
        selectedBook = null;
    }

    public void removeUser(User user){
        userRepo.removeUser(user);
        selectedUser = null;
    }

    public void removeAuthor(Author author){
        authorRepo.removeAuthor(author);
        selectedAuthor = null;
    }

    public void addBook(){
        bookRepo.addBook(selectedAuthor);
        selectedAuthor = null;
    }

    public void addLoan(){
        loanRepo.addLoan(selectedUser, selectedBook);
        selectedUser = null;
        selectedBook = null;
    }

    public MonsterQuery getMonsterQuery() {
        return monsterQuery;
    }

    public BookRepository getBookRepo() {
        return bookRepo;
    }

    public UserRepository getUserRepo() {
        return userRepo;
    }

    public LoanRepository getLoanRepo() {
        return loanRepo;
    }

    public AuthorRepository getAuthorRepo() {
        return authorRepo;
    }

    public User getSelectedUser() {
        System.out.println("GETTT");
        System.out.println(selectedUser);
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        System.out.println(selectedUser);
        this.selectedUser = selectedUser;
    }

    public Author getSelectedAuthor() {
        return selectedAuthor;
    }

    public void setSelectedAuthor(Author selectedAuthor) {
        this.selectedAuthor = selectedAuthor;
    }

    public Book getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = selectedBook;
    }
}
