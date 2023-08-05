package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.etc.JobType;

@Getter
@Setter
public class Pendant1 extends Item {

    public Pendant1(JobType jobType) {
        super(160L, jobType);
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addOtherStat1(10L);
        this.addOtherStat2(10L);
        this.addAtt(3L);
        this.addMagic(3L);
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
