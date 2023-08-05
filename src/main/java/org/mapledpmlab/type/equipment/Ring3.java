package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.etc.JobType;

@Getter
@Setter
public class Ring3 extends Item {

    public Ring3(JobType jobType) {
        super(jobType, 140L);
        this.addMainStat(5L);
        this.addSubStat(5L);
        this.addOtherStat1(5L);
        this.addOtherStat2(5L);
        this.addAtt(1L);
        this.addMagic(1L);
        this.addHp(200L / 2);
        if (jobType == JobType.DEMON_AVENGER) {
            this.addHp((long) (250 * 2) / 2);
        } else if (jobType == JobType.XENON) {
            this.addMainStat((long) (3 * 2));
            this.addSubStat((long) (3 * 2));
            this.addOtherStat1((long) (3 * 2));
            this.addOtherStat2((long) (3 * 2));
        } else  {
            this.addMainStat((long) (5 * 2));
        }
    }
}
