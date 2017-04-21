package demo.compassites.mvpdemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import demo.compassites.mvpdemo.feature.Products.presenter.ProductListPresenter;
import demo.compassites.mvpdemo.feature.Products.view.contract.ListView;

import static org.junit.Assert.assertNotEquals;

/**
 * ProductList local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {
    ProductListPresenter list;
    @Mock
    ListView listView;

    @Before
    public void setUp() {
//        list = new ProductListPresenter(listView);
        assertNotEquals(list, null);
    }
    @Test
    public void addition_isCorrect() throws Exception {
    }
}