package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.etc.JobType;

@Getter
@Setter
public class Shoulder extends Item {

    public Shoulder(JobType jobType) {
        super(200L, jobType);
        this.addMainStat(35L);
        this.addSubStat(35L);
        this.addOtherStat1(35L);
        this.addOtherStat2(35L);
        this.addAtt(20L);
        this.addMagic(20L);
        if (jobType == JobType.DEMON_AVENGER) {
            this.addHp((long) (670 * 2) / 2);
        } else if (jobType == JobType.XENON) {
            this.addMainStat((long) (4 * 2));
            this.addSubStat((long) (4 * 2));
            this.addOtherStat1((long) (4 * 2));
            this.addOtherStat2((long) (4 * 2));
        } else  {
            this.addMainStat((long) (10 * 2));
        }
    }
}
