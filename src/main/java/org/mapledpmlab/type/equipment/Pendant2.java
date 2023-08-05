package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.etc.JobType;

@Getter
@Setter
public class Pendant2 extends Item {

    public Pendant2(JobType jobType) {
        super(140L, jobType);
        this.addMainStat(8L);
        this.addSubStat(8L);
        this.addOtherStat1(8L);
        this.addOtherStat2(8L);
        this.addAtt(2L);
        this.addMagic(2L);
        if (jobType == JobType.DEMON_AVENGER) {
            this.addMainStatP(5L);
            this.addHp((long) (250 * 6) / 2);
        } else if (jobType == JobType.XENON) {
            this.addMainStat((long) (3 * 6));
            this.addSubStat((long) (3 * 6));
            this.addOtherStat1((long) (3 * 6));
            this.addOtherStat2((long) (3 * 6));
        } else  {
            this.addMainStat((long) (5 * 6));
        }
        this.addAtt(1L);
        this.addMagic(1L);
    }
}
