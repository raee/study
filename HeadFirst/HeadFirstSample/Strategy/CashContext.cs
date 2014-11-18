using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HeadFirstSample.Strategy
{
    /// <summary>
    /// 收费策略上下文，用来维护一个策略对象的引用。
    /// </summary>
    public class CashContext
    {
        private readonly CashStrategy _strategy;

        public CashContext(CashStrategy strategy)
        {
            _strategy = strategy;
        }

        public double GetResult(double money)
        {
            return _strategy.AcceptCash(money);
        }
    }
}
