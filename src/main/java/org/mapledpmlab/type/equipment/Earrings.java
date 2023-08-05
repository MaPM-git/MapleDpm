package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.etc.JobType;

@Getter
@Setter
public class Earrings extends Item {

    public Earrings(JobType jobType) {
        super(200L, jobType);
        this.addMainStat(7L);
        this.addSubStat(7L);
        this.addOtherStat1(7L);
        this.addOtherStat2(7L);
        this.addAtt(5L);
        this.addMagic(5L);
        this.addHp(500L / 2);
        if (jobType == JobType.DEMON_AVENGER) {
            this.addHp((long) (250 * 7) / 2);
        } else if (jobType == JobType.XENON) {
            this.addMainStat((long) (3 * 7));
            this.addSubStat((long) (3 * 7));
            this.addOtherStat1((long) (3 * 7));
            this.addOtherStat2((long) (3 * 7));
        } else  {
            this.addMainStat((long) (5 * 7));
        }
        this.addAtt(1L);
        this.addMagic(1L);
    }
}
