package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.etc.JobType;

@Getter
@Setter
public class Eye extends Item {

    public Eye(JobType jobType) {
        super(160L, jobType);
        this.addMainStat(15L);
        this.addSubStat(15L);
        this.addOtherStat1(15L);
        this.addOtherStat2(15L);
        this.addAtt(3L);
        this.addMagic(3L);
        if (jobType == JobType.DEMON_AVENGER) {
            this.addHp((long) (250 * 4) / 2);
        } else if (jobType == JobType.XENON) {
            this.addMainStat((long) (3 * 4));
            this.addSubStat((long) (3 * 4));
            this.addOtherStat1((long) (3 * 4));
            this.addOtherStat2((long) (3 * 4));
        } else  {
            this.addMainStat((long) (5 * 4));
        }
        this.addAtt(1L);
        this.addMagic(1L);
    }
}
