package nz.ac.auckland.se281;

import static nz.ac.auckland.se281.Command.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
  MainTest.Task1.class,
  MainTest.Task2.class, // Uncomment this line when you start Task 2
  MainTest.Task3.class, // Uncomment this line when you start Task 3
  MainTest.YourTests.class, // Uncomment this line to run your own tests
})
public class MainTest {
  public static class Task1 extends CliTest {
    public Task1() {
      super(Main.class);
    }

    @Test
    public void T1_A_roots() throws Exception {
      runCommands(OPEN_FILE, "a.txt", LIST_ROOT_VERTICIES);
      assertContains("Successfully opened graph from file a.txt");
      assertContains("[0]");
    }

    @Test
    public void T1_B_roots() throws Exception {
      runCommands(OPEN_FILE, "b.txt", LIST_ROOT_VERTICIES);
      assertContains("Successfully opened graph from file b.txt");
      assertContains("[6]");
    }

    @Test
    public void T1_C_roots() throws Exception {
      runCommands(OPEN_FILE, "c.txt", LIST_ROOT_VERTICIES);
      assertContains("Successfully opened graph from file c.txt");
      assertContains("[0, 1]");
    }

    @Test
    public void T1_A_reflexivity() throws Exception {
      runCommands(OPEN_FILE, "a.txt", CHECK_REFLEXIVITY);
      assertContains("Successfully opened graph from file a.txt");
      assertContains("The graph is NOT reflexive");
    }

    @Test
    public void T1_B_reflexivity() throws Exception {
      runCommands(OPEN_FILE, "b.txt", CHECK_REFLEXIVITY);
      assertContains("Successfully opened graph from file b.txt");
      assertContains("The graph is NOT reflexive");
    }

    @Test
    public void T1_C_reflexivity() throws Exception {
      runCommands(OPEN_FILE, "c.txt", CHECK_REFLEXIVITY);
      assertContains("Successfully opened graph from file c.txt");
      assertContains("The graph is reflexive");
    }

    @Test
    public void T1_A_symmetry() throws Exception {
      runCommands(OPEN_FILE, "a.txt", CHECK_SYMMETRY);
      assertContains("Successfully opened graph from file a.txt");
      assertContains("The graph is NOT symmetric");
    }

    @Test
    public void T1_B_symmetry() throws Exception {
      runCommands(OPEN_FILE, "b.txt", CHECK_SYMMETRY);
      assertContains("Successfully opened graph from file b.txt");
      assertContains("The graph is NOT symmetric");
    }

    @Test
    public void T1_C_symmetry() throws Exception {
      runCommands(OPEN_FILE, "c.txt", CHECK_SYMMETRY);
      assertContains("Successfully opened graph from file c.txt");
      assertContains("The graph is symmetric");
    }

    @Test
    public void T1_A_transitivity() throws Exception {
      runCommands(OPEN_FILE, "a.txt", CHECK_TRANSITIVITY);
      assertContains("Successfully opened graph from file a.txt");
      assertContains("The graph is NOT transitive");
    }

    @Test
    public void T1_B_transitivity() throws Exception {
      runCommands(OPEN_FILE, "b.txt", CHECK_TRANSITIVITY);
      assertContains("Successfully opened graph from file b.txt");
      assertContains("The graph is NOT transitive");
    }

    @Test
    public void T1_C_transitivity() throws Exception {
      runCommands(OPEN_FILE, "c.txt", CHECK_TRANSITIVITY);
      assertContains("Successfully opened graph from file c.txt");
      assertContains("The graph is transitive");
    }

    @Test
    public void T1_A_antisymmetry() throws Exception {
      runCommands(OPEN_FILE, "a.txt", CHECK_ANTISYMMETRY);
      assertContains("Successfully opened graph from file a.txt");
      assertContains("The graph is antisymmetric");
    }

    @Test
    public void T1_B_antisymmetry() throws Exception {
      runCommands(OPEN_FILE, "b.txt", CHECK_ANTISYMMETRY);
      assertContains("Successfully opened graph from file b.txt");
      assertContains("The graph is NOT antisymmetric");
    }

    @Test
    public void T1_C_antisymmetry() throws Exception {
      runCommands(OPEN_FILE, "c.txt", CHECK_ANTISYMMETRY);
      assertContains("Successfully opened graph from file c.txt");
      assertContains("The graph is NOT antisymmetric");
    }

    @Test
    public void T1_A_equivalence() throws Exception {
      runCommands(OPEN_FILE, "a.txt", CHECK_EQUIVALENCE);
      assertContains("Successfully opened graph from file a.txt");
      assertContains("The graph is NOT an equivalence relation");
    }

    @Test
    public void T1_B_equivalence() throws Exception {
      runCommands(OPEN_FILE, "b.txt", CHECK_EQUIVALENCE);
      assertContains("Successfully opened graph from file b.txt");
      assertContains("The graph is NOT an equivalence relation");
    }

    @Test
    public void T1_C_equivalence() throws Exception {
      runCommands(OPEN_FILE, "c.txt", CHECK_EQUIVALENCE);
      assertContains("Successfully opened graph from file c.txt");
      assertContains("The graph is an equivalence relation");
    }

    @Test
    public void T1_B_equivalence_class_1() throws Exception {
      runCommands(OPEN_FILE, "b.txt", COMPUTE_EQUIVALENCE, 1);
      assertContains("Successfully opened graph from file b.txt");
      assertContains("[]");
    }

    @Test
    public void T1_C_equivalence_class_0() throws Exception {
      runCommands(OPEN_FILE, "c.txt", COMPUTE_EQUIVALENCE, 0);
      assertContains("Successfully opened graph from file c.txt");
      assertContains("[0]");
    }

    @Test
    public void T1_C_equivalence_class_1() throws Exception {
      runCommands(OPEN_FILE, "c.txt", COMPUTE_EQUIVALENCE, 1);
      assertContains("Successfully opened graph from file c.txt");
      assertContains("[1, 2, 3]");
    }
  }

  public static class Task2 extends CliTest {
    public Task2() {
      super(Main.class);
    }

    @Test
    public void T2_A_iterative_BFS() throws Exception {
      runCommands(OPEN_FILE, "a.txt", GRAPH_SEARCH_IBFS);
      assertContains("Successfully opened graph from file a.txt");
      assertContains("[0, 1, 2, 3, 4, 5]");
    }

    @Test
    public void T2_B_iterative_BFS() throws Exception {
      runCommands(OPEN_FILE, "b.txt", GRAPH_SEARCH_IBFS);
      assertContains("Successfully opened graph from file b.txt");
      assertContains("[6, 5, 4, 3, 2, 1, 0]");
    }

    @Test
    public void T2_C_iterative_BFS() throws Exception {
      runCommands(OPEN_FILE, "c.txt", GRAPH_SEARCH_IBFS);
      assertContains("Successfully opened graph from file c.txt");
      assertContains("[0, 1, 2, 3]");
    }

    @Test
    public void T2_A_iterative_DFS() throws Exception {
      runCommands(OPEN_FILE, "a.txt", GRAPH_SEARCH_IDFS);
      assertContains("Successfully opened graph from file a.txt");
      assertContains("[0, 1, 3, 4, 5, 2]");
    }

    @Test
    public void T2_B_iterative_DFS() throws Exception {
      runCommands(OPEN_FILE, "b.txt", GRAPH_SEARCH_IDFS);
      assertContains("Successfully opened graph from file b.txt");
      assertContains("[6, 5, 4, 3, 2, 1, 0]");
    }

    @Test
    public void T2_C_iterative_DFS() throws Exception {
      runCommands(OPEN_FILE, "c.txt", GRAPH_SEARCH_IDFS);
      assertContains("Successfully opened graph from file c.txt");
      assertContains("[0, 1, 2, 3]");
    }
  }

  public static class Task3 extends CliTest {
    public Task3() {
      super(Main.class);
    }

    @Test
    public void T3_A_recursive_BFS() throws Exception {
      runCommands(OPEN_FILE, "a.txt", GRAPH_SEARCH_RBFS);
      assertContains("Successfully opened graph from file a.txt");
      assertContains("[0, 1, 2, 3, 4, 5]");
    }

    @Test
    public void T3_B_recursive_BFS() throws Exception {
      runCommands(OPEN_FILE, "b.txt", GRAPH_SEARCH_RBFS);
      assertContains("Successfully opened graph from file b.txt");
      assertContains("[6, 5, 4, 3, 2, 1, 0]");
    }

    @Test
    public void T3_C_recursive_BFS() throws Exception {
      runCommands(OPEN_FILE, "c.txt", GRAPH_SEARCH_RBFS);
      assertContains("Successfully opened graph from file c.txt");
      assertContains("[0, 1, 2, 3]");
    }

    @Test
    public void T3_A_recursive_DFS() throws Exception {
      runCommands(OPEN_FILE, "a.txt", GRAPH_SEARCH_RDFS);
      assertContains("Successfully opened graph from file a.txt");
      assertContains("[0, 1, 3, 4, 5, 2]");
    }

    @Test
    public void T3_B_recursive_DFS() throws Exception {
      runCommands(OPEN_FILE, "b.txt", GRAPH_SEARCH_RDFS);
      assertContains("Successfully opened graph from file b.txt");
      assertContains("[6, 5, 4, 3, 2, 1, 0]");
    }

    @Test
    public void T3_C_recursive_DFS() throws Exception {
      runCommands(OPEN_FILE, "c.txt", GRAPH_SEARCH_RDFS);
      assertContains("Successfully opened graph from file c.txt");
      assertContains("[0, 1, 2, 3]");
    }
  }

  public static class YourTests extends CliTest {
    public YourTests() {
      super(Main.class);
    }

    @Test
    public void F_TXT_iterative_BFS() throws Exception {
      runCommands(OPEN_FILE, "f.txt", GRAPH_SEARCH_IBFS);
      assertContains("Successfully opened graph from file f.txt");
      assertContains(
          "[1, 2, 3, 4, 5, 10, 6, 7, 9, 8, 11, 15, 22, 29, 16, 23, 30, 13, 20, 27, 12, 19, 26, 14,"
              + " 21, 28, 17, 24, 31, 18, 25, 32]");
    }

    @Test
    public void F_TXT_iterative_DFS() throws Exception {
      runCommands(OPEN_FILE, "f.txt", GRAPH_SEARCH_IDFS);
      assertContains("Successfully opened graph from file f.txt");
      assertContains(
          "[1, 2, 5, 15, 22, 29, 10, 16, 23, 30, 3, 6, 13, 20, 27, 7, 12, 19, 26, 9, 14, 21, 28, 4,"
              + " 8, 17, 24, 31, 11, 18, 25, 32]");
    }

    @Test
    public void F_TXT_recursive_BFS() throws Exception {
      runCommands(OPEN_FILE, "f.txt", GRAPH_SEARCH_RBFS);
      assertContains("Successfully opened graph from file f.txt");
      assertContains(
          "[1, 2, 3, 4, 5, 10, 6, 7, 9, 8, 11, 15, 22, 29, 16, 23, 30, 13, 20, 27, 12, 19, 26, 14,"
              + " 21, 28, 17, 24, 31, 18, 25, 32]");
    }

    @Test
    public void F_TXT_recursive_DFS() throws Exception {
      runCommands(OPEN_FILE, "f.txt", GRAPH_SEARCH_RDFS);
      assertContains("Successfully opened graph from file f.txt");
      assertContains(
          "[1, 2, 5, 15, 22, 29, 10, 16, 23, 30, 3, 6, 13, 20, 27, 7, 12, 19, 26, 9, 14, 21, 28, 4,"
              + " 8, 17, 24, 31, 11, 18, 25, 32]");
    }

    @Test
    public void G_TXT_iterative_BFS() throws Exception {
      runCommands(OPEN_FILE, "g.txt", GRAPH_SEARCH_IBFS);
      assertContains("Successfully opened graph from file g.txt");
      assertContains("[1, 3, 5, 6, 9, 11, 7, 2, 12, 4, 8, 10]");
    }

    @Test
    public void G_TXT_iterative_DFS() throws Exception {
      runCommands(OPEN_FILE, "g.txt", GRAPH_SEARCH_IDFS);
      assertContains("Successfully opened graph from file g.txt");
      assertContains("[1, 3, 5, 7, 6, 2, 4, 10, 8, 9, 11, 12]");
    }

    @Test
    public void G_TXT_recursive_BFS() throws Exception {
      runCommands(OPEN_FILE, "g.txt", GRAPH_SEARCH_RBFS);
      assertContains("Successfully opened graph from file g.txt");
      assertContains("[1, 3, 5, 6, 9, 11, 7, 2, 12, 4, 8, 10]");
    }

    @Test
    public void G_TXT_recursive_DFS() throws Exception {
      runCommands(OPEN_FILE, "g.txt", GRAPH_SEARCH_RDFS);
      assertContains("Successfully opened graph from file g.txt");
      assertContains("[1, 3, 5, 7, 6, 2, 4, 10, 8, 9, 11, 12]");
    }

    @Test
    public void TY_H_roots() throws Exception {
      runCommands(OPEN_FILE, "h.txt", LIST_ROOT_VERTICIES);
      assertContains("Successfully opened graph from file h.txt");
      assertContains("[1]");
    }

    @Test
    public void TY_H_reflexivity() throws Exception {
      runCommands(OPEN_FILE, "h.txt", CHECK_REFLEXIVITY);
      assertContains("Successfully opened graph from file h.txt");
      assertContains("The graph is reflexive");
    }

    @Test
    public void TY_H_symmetry() throws Exception {
      runCommands(OPEN_FILE, "h.txt", CHECK_SYMMETRY);
      assertContains("Successfully opened graph from file h.txt");
      assertContains("The graph is symmetric");
    }

    @Test
    public void TY_H_antisymmetry() throws Exception {
      runCommands(OPEN_FILE, "h.txt", CHECK_ANTISYMMETRY);
      assertContains("Successfully opened graph from file h.txt");
      assertContains("The graph is NOT antisymmetric");
    }

    @Test
    public void TY_H_transitivity() throws Exception {
      runCommands(OPEN_FILE, "h.txt", CHECK_TRANSITIVITY);
      assertContains("Successfully opened graph from file h.txt");
      assertContains("The graph is transitive");
    }

    @Test
    public void TY_H_equivalence() throws Exception {
      runCommands(OPEN_FILE, "h.txt", CHECK_EQUIVALENCE);
      assertContains("Successfully opened graph from file h.txt");
      assertContains("The graph is an equivalence relation");
    }

    @Test
    public void TY_H_equivalence_class_1() throws Exception {
      runCommands(OPEN_FILE, "h.txt", COMPUTE_EQUIVALENCE, 1);
      assertContains("Successfully opened graph from file h.txt");
      assertContains("[1, 2, 3, 4]");
    }

    @Test
    public void TY_I_roots() throws Exception {
      runCommands(OPEN_FILE, "i.txt", LIST_ROOT_VERTICIES);
      assertContains("Successfully opened graph from file i.txt");
      assertContains("[]");
    }

    @Test
    public void TY_I_reflexivity() throws Exception {
      runCommands(OPEN_FILE, "i.txt", CHECK_REFLEXIVITY);
      assertContains("Successfully opened graph from file i.txt");
      assertContains("The graph is reflexive");
    }

    @Test
    public void TY_I_symmetry() throws Exception {
      runCommands(OPEN_FILE, "i.txt", CHECK_SYMMETRY);
      assertContains("Successfully opened graph from file i.txt");
      assertContains("The graph is NOT symmetric");
    }

    @Test
    public void TY_I_antisymmetry() throws Exception {
      runCommands(OPEN_FILE, "i.txt", CHECK_ANTISYMMETRY);
      assertContains("Successfully opened graph from file i.txt");
      assertContains("The graph is NOT antisymmetric");
    }

    @Test
    public void TY_I_transitivity() throws Exception {
      runCommands(OPEN_FILE, "i.txt", CHECK_TRANSITIVITY);
      assertContains("Successfully opened graph from file i.txt");
      assertContains("The graph is transitive");
    }

    @Test
    public void TY_I_equivalence() throws Exception {
      runCommands(OPEN_FILE, "i.txt", CHECK_EQUIVALENCE);
      assertContains("Successfully opened graph from file i.txt");
      assertContains("The graph is NOT an equivalence relation");
    }

    @Test
    public void TY_I_equivalence_class_0() throws Exception {
      runCommands(OPEN_FILE, "i.txt", COMPUTE_EQUIVALENCE, 1);
      assertContains("Successfully opened graph from file i.txt");
      assertContains("[]");
    }

    @Test
    public void TY_J_roots() throws Exception {
      runCommands(OPEN_FILE, "j.txt", LIST_ROOT_VERTICIES);
      assertContains("Successfully opened graph from file j.txt");
      assertContains("[0]");
    }

    @Test
    public void TY_J_reflexivity() throws Exception {
      runCommands(OPEN_FILE, "j.txt", CHECK_REFLEXIVITY);
      assertContains("Successfully opened graph from file j.txt");
      assertContains("The graph is reflexive");
    }

    @Test
    public void TY_J_symmetry() throws Exception {
      runCommands(OPEN_FILE, "j.txt", CHECK_SYMMETRY);
      assertContains("Successfully opened graph from file j.txt");
      assertContains("The graph is symmetric");
    }

    @Test
    public void TY_J_antisymmetry() throws Exception {
      runCommands(OPEN_FILE, "j.txt", CHECK_ANTISYMMETRY);
      assertContains("Successfully opened graph from file j.txt");
      assertContains("The graph is antisymmetric");
    }

    @Test
    public void TY_J_transitivity() throws Exception {
      runCommands(OPEN_FILE, "j.txt", CHECK_TRANSITIVITY);
      assertContains("Successfully opened graph from file j.txt");
      assertContains("The graph is transitive");
    }

    @Test
    public void TY_J_equivalence() throws Exception {
      runCommands(OPEN_FILE, "j.txt", CHECK_EQUIVALENCE);
      assertContains("Successfully opened graph from file j.txt");
      assertContains("The graph is an equivalence relation");
    }

    @Test
    public void TY_J_equivalence_class_0() throws Exception {
      runCommands(OPEN_FILE, "j.txt", COMPUTE_EQUIVALENCE, 0);
      assertContains("Successfully opened graph from file j.txt");
      assertContains("[0]");
    }

    ////////////////////////////////// Student chicken
    // dfs and bfs random graph, you can delete the successfully opend from file test case
    @Test
    public void TY_01_G_iterative_BFS() throws Exception {
      runCommands(OPEN_FILE, "n.txt", GRAPH_SEARCH_IBFS);
      assertContains("Successfully opened graph from file n.txt");
      assertContains("[1, 3, 5, 6, 9, 11, 7, 2, 12, 4, 8, 10]");
    }

    @Test
    public void TY_02_G_iterative_DFS() throws Exception {
      runCommands(OPEN_FILE, "n.txt", GRAPH_SEARCH_IDFS);
      assertContains("Successfully opened graph from file n.txt");
      assertContains("[1, 3, 5, 7, 6, 2, 4, 10, 8, 9, 11, 12]");
    }

    @Test
    public void TY_03_G_recursive_BFS() throws Exception {
      runCommands(OPEN_FILE, "n.txt", GRAPH_SEARCH_RBFS);
      assertContains("Successfully opened graph from file n.txt");
      assertContains("[1, 3, 5, 6, 9, 11, 7, 2, 12, 4, 8, 10]");
    }

    @Test
    public void TY_04_G_recursive_DFS() throws Exception {
      runCommands(OPEN_FILE, "n.txt", GRAPH_SEARCH_RDFS);
      assertContains("Successfully opened graph from file n.txt");
      assertContains("[1, 3, 5, 7, 6, 2, 4, 10, 8, 9, 11, 12]");
    }

    // dfs and bfs with 25 vertices
    @Test
    public void TY_01_H_iterative_BFS() throws Exception {
      runCommands(OPEN_FILE, "o.txt", GRAPH_SEARCH_IBFS);
      assertContains("Successfully opened graph from file o.txt");
      assertContains(
          "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,"
              + " 24]");
    }

    @Test
    public void TY_02_H_iterative_DFS() throws Exception {
      runCommands(OPEN_FILE, "o.txt", GRAPH_SEARCH_IDFS);
      assertContains("Successfully opened graph from file o.txt");
      assertContains(
          "[0, 1, 3, 7, 15, 19, 22, 24, 8, 4, 9, 16, 20, 23, 10, 2, 5, 11, 17, 21, 12, 6, 13, 18,"
              + " 14]");
    }

    @Test
    public void TY_03_H_recursive_BFS() throws Exception {
      runCommands(OPEN_FILE, "o.txt", GRAPH_SEARCH_RBFS);
      assertContains("Successfully opened graph from file o.txt");
      assertContains(
          "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,"
              + " 24]");
    }

    @Test
    public void TY_04_H_recursive_DFS() throws Exception {
      runCommands(OPEN_FILE, "o.txt", GRAPH_SEARCH_RDFS);
      assertContains("Successfully opened graph from file o.txt");
      assertContains(
          "[0, 1, 3, 7, 15, 19, 22, 24, 8, 4, 9, 16, 20, 23, 10, 2, 5, 11, 17, 21, 12, 6, 13, 18,"
              + " 14]");
    }

    // Check if the roots are given in order
    @Test
    public void TY_01_I_check_roots() throws Exception {
      runCommands(OPEN_FILE, "p.txt", LIST_ROOT_VERTICIES);
      assertContains("Successfully opened graph from file p.txt");
      assertContains("[0, 2, 10, 12, 20, 100]");
      assertDoesNotContain("[0, 10, 12, 100, 2, 20]");
    }

    // dfs and bfs of i.txt (or whatever you named the file I have given you)
    @Test
    public void TY_02_I_IBFS() throws Exception {
      runCommands(OPEN_FILE, "p.txt", GRAPH_SEARCH_IBFS);
      assertContains("Successfully opened graph from file p.txt");
      assertContains("[0, 1, 2, 3, 10, 11, 12, 13, 20, 21, 100, 101]");
    }

    @Test
    public void TY_03_I_RBFS() throws Exception {
      runCommands(OPEN_FILE, "p.txt", GRAPH_SEARCH_RBFS);
      assertContains("Successfully opened graph from file p.txt");
      assertContains("[0, 1, 2, 3, 10, 11, 12, 13, 20, 21, 100, 101]");
    }

    @Test
    public void TY_04_I_IDFS() throws Exception {
      runCommands(OPEN_FILE, "p.txt", GRAPH_SEARCH_IDFS);
      assertContains("Successfully opened graph from file p.txt");
      assertContains("[0, 1, 2, 3, 10, 11, 12, 13, 20, 21, 100, 101]");
    }

    @Test
    public void TY_05_I_RDFS() throws Exception {
      runCommands(OPEN_FILE, "p.txt", GRAPH_SEARCH_RDFS);
      assertContains("Successfully opened graph from file p.txt");
      assertContains("[0, 1, 2, 3, 10, 11, 12, 13, 20, 21, 100, 101]");
    }

    ///////////// Yishun Test Cases //////////////
    @Test
    public void TY_D_roots() throws Exception {
      runCommands(OPEN_FILE, "q.txt", LIST_ROOT_VERTICIES);
      assertContains("Successfully opened graph from file q.txt");
      assertContains("[1]");
    }

    @Test
    public void TY_D_reflexivity() throws Exception {
      runCommands(OPEN_FILE, "q.txt", CHECK_REFLEXIVITY);
      assertContains("Successfully opened graph from file q.txt");
      assertContains("The graph is reflexive");
    }

    @Test
    public void TY_D_symmetry() throws Exception {
      runCommands(OPEN_FILE, "q.txt", CHECK_SYMMETRY);
      assertContains("Successfully opened graph from file q.txt");
      assertContains("The graph is symmetric");
    }

    @Test
    public void TY_D_antisymmetry() throws Exception {
      runCommands(OPEN_FILE, "q.txt", CHECK_ANTISYMMETRY);
      assertContains("Successfully opened graph from file q.txt");
      assertContains("The graph is NOT antisymmetric");
    }

    @Test
    public void TY_D_transitivity() throws Exception {
      runCommands(OPEN_FILE, "q.txt", CHECK_TRANSITIVITY);
      assertContains("Successfully opened graph from file q.txt");
      assertContains("The graph is transitive");
    }

    @Test
    public void TY_D_equivalence() throws Exception {
      runCommands(OPEN_FILE, "q.txt", CHECK_EQUIVALENCE);
      assertContains("Successfully opened graph from file q.txt");
      assertContains("The graph is an equivalence relation");
    }

    @Test
    public void TY_D_equivalence_class_1() throws Exception {
      runCommands(OPEN_FILE, "q.txt", COMPUTE_EQUIVALENCE, 1);
      assertContains("Successfully opened graph from file q.txt");
      assertContains("[1, 2, 3, 4]");
    }

    @Test
    public void TY_E_roots() throws Exception {
      runCommands(OPEN_FILE, "r.txt", LIST_ROOT_VERTICIES);
      assertContains("Successfully opened graph from file r.txt");
      assertContains("[]");
    }

    @Test
    public void TY_E_reflexivity() throws Exception {
      runCommands(OPEN_FILE, "r.txt", CHECK_REFLEXIVITY);
      assertContains("Successfully opened graph from file r.txt");
      assertContains("The graph is reflexive");
    }

    @Test
    public void TY_E_symmetry() throws Exception {
      runCommands(OPEN_FILE, "r.txt", CHECK_SYMMETRY);
      assertContains("Successfully opened graph from file r.txt");
      assertContains("The graph is NOT symmetric");
    }

    @Test
    public void TY_E_antisymmetry() throws Exception {
      runCommands(OPEN_FILE, "r.txt", CHECK_ANTISYMMETRY);
      assertContains("Successfully opened graph from file r.txt");
      assertContains("The graph is NOT antisymmetric");
    }

    @Test
    public void TY_E_transitivity() throws Exception {
      runCommands(OPEN_FILE, "r.txt", CHECK_TRANSITIVITY);
      assertContains("Successfully opened graph from file r.txt");
      assertContains("The graph is transitive");
    }

    @Test
    public void TY_E_equivalence() throws Exception {
      runCommands(OPEN_FILE, "r.txt", CHECK_EQUIVALENCE);
      assertContains("Successfully opened graph from file r.txt");
      assertContains("The graph is NOT an equivalence relation");
    }

    @Test
    public void TY_E_equivalence_class_0() throws Exception {
      runCommands(OPEN_FILE, "r.txt", COMPUTE_EQUIVALENCE, 1);
      assertContains("Successfully opened graph from file r.txt");
      assertContains("[]");
    }

    @Test
    public void TY_F_roots() throws Exception {
      runCommands(OPEN_FILE, "s.txt", LIST_ROOT_VERTICIES);
      assertContains("Successfully opened graph from file s.txt");
      assertContains("[0]");
    }

    @Test
    public void TY_F_reflexivity() throws Exception {
      runCommands(OPEN_FILE, "s.txt", CHECK_REFLEXIVITY);
      assertContains("Successfully opened graph from file s.txt");
      assertContains("The graph is reflexive");
    }

    @Test
    public void TY_F_symmetry() throws Exception {
      runCommands(OPEN_FILE, "s.txt", CHECK_SYMMETRY);
      assertContains("Successfully opened graph from file s.txt");
      assertContains("The graph is symmetric");
    }

    @Test
    public void TY_F_antisymmetry() throws Exception {
      runCommands(OPEN_FILE, "s.txt", CHECK_ANTISYMMETRY);
      assertContains("Successfully opened graph from file s.txt");
      assertContains("The graph is antisymmetric");
    }

    @Test
    public void TY_F_transitivity() throws Exception {
      runCommands(OPEN_FILE, "s.txt", CHECK_TRANSITIVITY);
      assertContains("Successfully opened graph from file s.txt");
      assertContains("The graph is transitive");
    }

    @Test
    public void TY_F_equivalence() throws Exception {
      runCommands(OPEN_FILE, "s.txt", CHECK_EQUIVALENCE);
      assertContains("Successfully opened graph from file s.txt");
      assertContains("The graph is an equivalence relation");
    }

    @Test
    public void TY_F_equivalence_class_0() throws Exception {
      runCommands(OPEN_FILE, "s.txt", COMPUTE_EQUIVALENCE, 0);
      assertContains("Successfully opened graph from file s.txt");
      assertContains("[0]");
    }

    /////////////// Joshua's Test Cases ///////////////
    @Test
    public void TY_01_test_one_IBFS() throws Exception {
      runCommands(OPEN_FILE, "test-one.txt", GRAPH_SEARCH_IBFS);
      assertContains(
          "[1, 2, 3, 4, 5, 10, 6, 7, 9, 8, 11, 15, 22, 29, 16, 23, 30, 13, 20, 27, 12, 19, 26, 14,"
              + " 21, 28, 17, 24, 31, 18, 25, 32]");
    }

    @Test
    public void TY_02_test_one_RBFS() throws Exception {
      runCommands(OPEN_FILE, "test-one.txt", GRAPH_SEARCH_RBFS);
      assertContains(
          "[1, 2, 3, 4, 5, 10, 6, 7, 9, 8, 11, 15, 22, 29, 16, 23, 30, 13, 20, 27, 12, 19, 26, 14,"
              + " 21, 28, 17, 24, 31, 18, 25, 32]");
    }

    @Test
    public void TY_03_test_one_IDFS() throws Exception {
      runCommands(OPEN_FILE, "test-one.txt", GRAPH_SEARCH_IDFS);
      assertContains(
          "[1, 2, 5, 15, 22, 29, 10, 16, 23, 30, 3, 6, 13, 20, 27, 7, 12, 19, 26, 9, 14, 21, 28, 4,"
              + " 8, 17, 24, 31, 11, 18, 25, 32]");
    }

    @Test
    public void TY_04_test_one_RDFS() throws Exception {
      runCommands(OPEN_FILE, "test-one.txt", GRAPH_SEARCH_RDFS);
      assertContains(
          "[1, 2, 5, 15, 22, 29, 10, 16, 23, 30, 3, 6, 13, 20, 27, 7, 12, 19, 26, 9, 14, 21, 28, 4,"
              + " 8, 17, 24, 31, 11, 18, 25, 32]");
    }

    @Test
    public void TY_05_test_two_subgraphs_IBFS() throws Exception {
      runCommands(OPEN_FILE, "2-subgraphs.txt", GRAPH_SEARCH_IBFS);
      assertContains("[1, 2, 3, 4, 5, 6, 7]");
    }

    @Test
    public void TY_06_test_two_subgraphs_RBFS() throws Exception {
      runCommands(OPEN_FILE, "2-subgraphs.txt", GRAPH_SEARCH_RBFS);
      assertContains("[1, 2, 3, 4, 5, 6, 7]");
    }

    @Test
    public void TY_07_test_two_subgraphs_IDFS() throws Exception {
      runCommands(OPEN_FILE, "2-subgraphs.txt", GRAPH_SEARCH_IDFS);
      assertContains("[1, 2, 3, 4, 5, 6, 7]");
    }

    @Test
    public void TY_08_test_two_subgraphs_RDFS() throws Exception {
      runCommands(OPEN_FILE, "2-subgraphs.txt", GRAPH_SEARCH_RDFS);
      assertContains("[1, 2, 3, 4, 5, 6, 7]");
    }

    @Test
    public void TY_09_test_useless_root_IBFS() throws Exception {
      runCommands(OPEN_FILE, "useless-root.txt", GRAPH_SEARCH_IBFS);
      assertContains("[0, 1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void TY_10_test_useless_root_RBFS() throws Exception {
      runCommands(OPEN_FILE, "useless-root.txt", GRAPH_SEARCH_RBFS);
      assertContains("[0, 1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void TY_11_test_useless_root_IDFS() throws Exception {
      runCommands(OPEN_FILE, "useless-root.txt", GRAPH_SEARCH_IDFS);
      assertContains("[0, 1, 3, 4, 5, 2, 6]");
    }

    @Test
    public void TY_09_test_useless_root_RDFS() throws Exception {
      runCommands(OPEN_FILE, "useless-root.txt", GRAPH_SEARCH_RDFS);
      assertContains("[0, 1, 3, 4, 5, 2, 6]");
    }
  }
}
