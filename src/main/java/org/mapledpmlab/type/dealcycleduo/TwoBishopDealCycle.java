package org.mapledpmlab.type.dealcycleduo;

import org.mapledpmlab.type.dealcyclesolo.Bishop2DealCycle;
import org.mapledpmlab.type.etc.DuoDealCycle;
import org.mapledpmlab.type.job.Bishop;

public class TwoBishopDealCycle extends DuoDealCycle {

    public TwoBishopDealCycle() {
        setDealCycle1(new Bishop2DealCycle(new Bishop()));
        setDealCycle2(new Bishop2DealCycle(new Bishop()));

        getDealCycle1().applyDoping();
        getDealCycle2().applyDoping();

        getDealCycle1().setSoloDealCycle();
        getDealCycle2().setDuoDealCycle();
    }
}
