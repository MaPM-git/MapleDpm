package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.etc.JobType;

@Getter
@Setter
public class Shoes extends Item {

    public Shoes(JobType jobType) {
        super(200L, jobType);
        this.addMainStat(40L);
        this.addSubStat(40L);
        this.addAtt(9L);
        if (jobType == JobType.DEMON_AVENGER) {
            this.addHp((long) (670 * 8) / 2);
        } else if (jobType == JobType.XENON) {
            this.addMainStat((long) (4 * 8));
            this.addSubStat((long) (4 * 8));
            this.addOtherStat1((long) (4 * 8));
            this.addOtherStat2((long) (4 * 8));
        } else  {
            this.addMainStat((long) (10 * 8));
        }
        this.addAtt(1L);
        this.addMagic(1L);
    }
}
