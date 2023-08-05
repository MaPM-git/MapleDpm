package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.etc.JobType;

@Getter
@Setter
public class Cape extends Item {

    public Cape(JobType jobType) {
        super(200L, jobType);
        this.addMainStat(35L);
        this.addSubStat(35L);
        this.addOtherStat1(35L);
        this.addOtherStat2(35L);
        this.addAtt(6L);
        this.addMagic(6L);
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
