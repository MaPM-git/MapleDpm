package org.mapledpmlab.type.equipment;

import org.mapledpmlab.type.etc.JobType;

public class Hat extends Item {

    public Hat(JobType jobType) {
        super(150L, jobType);
        this.addMainStat(40L);
        this.addSubStat(40L);
        this.addHp(360L / 2);
        this.addAtt(2L);
        this.addIgnoreDefenseList(10L);
        if (jobType == JobType.DEMON_AVENGER) {
            this.addCooldownReductionSec(2L);
            this.addHp((long) (670 * 12) / 2);
            this.addMainStatP(-12L);
            if (this.getLevel() == 250L) {
                this.addMainStatP(-1L);
            }
        } else if (jobType == JobType.XENON) {
            this.addCooldownReductionSec(2L);
            this.addMainStat((long) (4 * 12));
            this.addSubStat((long) (4 * 12));
            this.addOtherStat1((long) (4 * 12));
            this.addOtherStat2((long) (4 * 12));
            this.addAllStatP(-9L);
            if (this.getLevel() == 250) {
                this.addAllStatP(-1L);
            }
        } else if (jobType == JobType.COOLDOWN_REDUCTION1) {
            this.addCooldownReductionSec(1L);
            this.addMainStat((long) (12 * 10));
            this.addMainStatP(-8L);
            if (this.getLevel() == 250) {
                this.addMainStatP(-1L);
            }
        } else if (jobType == JobType.COOLDOWN_REDUCTION2) {
            this.addCooldownReductionSec(2L);
            this.addMainStat((long) (12 * 10));
            this.addMainStatP(-12L);
            if (this.getLevel() == 250) {
                this.addMainStatP(-1L);
            }
        } else if (jobType == JobType.COOLDOWN_REDUCTION3) {
            this.addCooldownReductionSec(3L);
            this.addMainStat((long) (12 * 10));
            this.addMainStatP(-20L);
            if (this.getLevel() == 250) {
                this.addMainStatP(-2L);
            }
        } else if (jobType == JobType.COOLDOWN_REDUCTION4) {
            this.addCooldownReductionSec(4L);
            this.addMainStat((long) (12 * 10));
            this.addMainStatP(-24L);
            if (this.getLevel() == 250) {
                this.addMainStatP(-2L);
            }
        } else if (jobType == JobType.COOLDOWN_REDUCTION_MAX) {
            this.addCooldownReductionSec(5L);
            this.addMainStat((long) (12 * 10));
            this.addMainStatP(-32L);
            if (this.getLevel() == 250) {
                this.addMainStatP(-3L);
            }
        }
        this.addAtt(1L);
        this.addMagic(1L);
    }
}
